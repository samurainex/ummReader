package com.samurainex.ummreader.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

/**
 * Created by w_priyambodo on 10/23/13.
 */
public class Provider extends ContentProvider {

    private Database db;

    private static final String AUTHORITY = "com.samurainex.ummreader";

    private static final String BASE = "db";

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE);

    private static final int FEED = 31;
    private static final int ARTICLE = 32;

    private static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {

    }

    @Override
    public boolean onCreate() {

        db = new Database(getContext());

        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder query = new SQLiteQueryBuilder();
        SQLiteDatabase sql = db.getReadableDatabase();

        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
