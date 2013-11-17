package com.samurainex.ummreader.parser;

import com.samurainex.ummreader.model.Article;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by w_priyambodo on 10/21/13.
 */
public class RssHandler extends DefaultHandler {

    //TODO http://stackoverflow.com/questions/6619717/what-is-the-difference-between-rss-and-atom-feeds

    private Article article;
    private List<Article> articles;

    private StringBuffer chars;

    private int count;
    private int limit; //TODO there should be an option for this

    private boolean init;

    public RssHandler() {
        article = new Article();
        articles = new ArrayList<Article>();
    }

    public List<Article> getArticles() {
        return articles;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        chars = new StringBuffer();

        if (!init) {
            if (localName.equalsIgnoreCase("rss")) {
                article.setFormat(Article.RSS);
            } else if (localName.equalsIgnoreCase("feed")) {
                article.setFormat(Article.ATOM);
            }

            init = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        chars.append(new String(ch, start, length));

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (init) {
            if (article.getFormat() == Article.RSS) {
                processRssFeed(localName);
            } else {
                processAtomFeed(localName);
            }
        }
    }

    private void processRssFeed(String localName) {

        if (localName.equalsIgnoreCase("title")){
            article.setTitle(chars.toString());
        } else if (localName.equalsIgnoreCase("description")){
            article.setDescription(chars.toString());
        } else if (localName.equalsIgnoreCase("published")){
            article.setPubDate(chars.toString());
        } else if (localName.equalsIgnoreCase("guid")){
            article.setId(chars.toString());
        } else if (localName.equalsIgnoreCase("author")){
            article.setAuthor(chars.toString());
        } else if (localName.equalsIgnoreCase("content")){
            article.setContent(chars.toString());
        } else if (localName.equalsIgnoreCase("item")){

            articles.add(article);
            count++;

            if (articles.size() >= limit) {
                return;
            } else {
                article = new Article();
            }
        }
    }

    private void processAtomFeed(String localName) {

        if (localName.equalsIgnoreCase("title")){
            article.setTitle(chars.toString());
        } else if (localName.equalsIgnoreCase("description")){
            article.setDescription(chars.toString());
        } else if (localName.equalsIgnoreCase("pubDate")){
            article.setPubDate(chars.toString());
        } else if (localName.equalsIgnoreCase("id")){
            article.setId(chars.toString());
        } else if (localName.equalsIgnoreCase("author")){
            article.setAuthor(chars.toString());
        } else if (localName.equalsIgnoreCase("content")){
            article.setContent(chars.toString());
        } else if (localName.equalsIgnoreCase("entry")){

            articles.add(article);
            count++;

            if (articles.size() >= limit) {
                return;
            } else {
                article = new Article();
            }

        }
    }
}
