package com.darkness.eventmanager.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "events_list.db";
    private static final String EVENT_TABLE_NAME = "events";
    public static final String EVENT_COLUMN_TITLE = "title";
    public static final String EVENT_COLUMN_TIME = "time";
    public static final String EVENT_COLUMN_READABLE_DATE = "readable_date";
    public static final String EVENT_COLUMN_ID = "id";
    public static final String EVENT_COLUMN_REQUEST_CODE = "rc";


    public DbHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table events (id integer primary key autoincrement,title text,time text,readable_date text,rc integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertNewEvent(String title, String time, String readable_date, int rqCode){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENT_COLUMN_TITLE,title);
        contentValues.put(EVENT_COLUMN_TIME,time);
        contentValues.put(EVENT_COLUMN_READABLE_DATE,readable_date);
        contentValues.put(EVENT_COLUMN_REQUEST_CODE,rqCode);
        db.insert(EVENT_TABLE_NAME, null, contentValues);
    }

    public Cursor getAllEvents(){
        SQLiteDatabase database = this.getReadableDatabase();
        return database.rawQuery("select * from "+EVENT_TABLE_NAME+";",null);
    }

    public void deleteEvent(String date){
        this.getReadableDatabase().delete(EVENT_TABLE_NAME,"readable_date = '"+date+"'",null);
    }

}
