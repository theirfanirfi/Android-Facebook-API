package com.example.irfanirfi.facebookapi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Irfan Irfi on 9/24/2017.
 */

public class Database extends SQLiteOpenHelper {
    public static final String ID = "ID";
    public static final String TITLE = "TITLE";
    public static final String TEXT = "TEXT";
    public static final String DB_NAME = "myd.db";
    public static final String TABLE_NAME = "records";
    public static final String DATE_TABLE_NAME = "date_tbl";
    public static final String CREATE_TABLE = "CREATE TABLE "
            +TABLE_NAME+"("+ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TITLE+" VARCHAR(255) NOT NULL, "+TEXT+" VARCHAR(255) NOT NULL);";
//    public static final String CREATE_DATE_TABLE = "CREATE TABLE "+DATE_TABLE_NAME+"(ID INTEER);";


    public Database(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       // sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    public boolean insert(String title,String text)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITLE,title);
        values.put(TEXT,text);
        long res = db.insert(TABLE_NAME,null,values);
        if(res == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public boolean insertData(String title,String text)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITLE,title);
        values.put(TEXT,text);
        long result = db.insert(TABLE_NAME,null,values);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res  = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return  res;
    }
}
