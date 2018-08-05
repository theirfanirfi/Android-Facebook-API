package com.example.irfanirfi.facebookapi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Irfan Irfi on 9/25/2017.
 */

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DB_NAME = "testing.db";
    private static final String TABLE_NAME = "tsting";
    private static final String ID = "ID";
    private static final String TITLE = "TITLE";
    private static final String TEXT = "TEXT";



    public MyDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
