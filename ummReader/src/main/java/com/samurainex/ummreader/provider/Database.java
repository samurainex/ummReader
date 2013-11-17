package com.samurainex.ummreader.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by w_priyambodo on 10/23/13.
 */
public class Database extends SQLiteOpenHelper {

    private static final String DB_NAME = "rss.db";

    private static final int DB_VERSION = 1;

    private static final String TABLE_COLUMN_ID = "_id";

    private static final String TABLE_FEED = "feed";
    private static final String TABLE_FEED_KEY = "feed_id";
    private static final String TABLE_FEED_NAME = "name";
    private static final String TABLE_FEED_URL = "url";

    private static final String TABLE_ARTICLE = "article";
    private static final String TABLE_ARTICLE_KEY = "article_id";
    private static final String TABLE_ARTICLE_TITLE = "title";
    private static final String TABLE_ARTICLE_URL = "url";
    private static final String TABLE_ARTICLE_READ = "read";

    private static final String TABLE_FEED_ARTICLE = "feed_article";


    private static final String DB_CREATE = "";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DB_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
