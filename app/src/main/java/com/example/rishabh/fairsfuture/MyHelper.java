package com.example.rishabh.fairsfuture;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rishabh on 12/9/2017.
 */

class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);
    }
    @Override    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ResumeLinks(_id integer primary key, link1 text, link2 text, link3 text, link4 text)");
        db.execSQL("create table Events(_id integer primary key, Event text, Date text, V text)");
        db.execSQL("create table ProfileInfo(_id integer primary key, Name text, University text, Graduation text, Major text)");
        db.execSQL("create table Employers(_id integer primary key, E1 text, E2 text, E3 text, E4 text, E5 text, E6 text)");
        db.execSQL("create table Booth(_id integer primary key, B1 text, B2 text, B3 text, B4 text, B5 text, B6 text)");
    }

    @Override    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}