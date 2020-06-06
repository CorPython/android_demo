package com.example.lab8exam01.sql_user;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 6;//数据库版本号
    private static final String DATABASE_NAME = "demo.db";
    DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建用户表
        String CREATE_TABLE_USER="CREATE TABLE "+ User.TABLE+"("
                +User.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                        +User.KEY_NAME+" TEXT, "
                        +User.KEY_PASSWORD+" TEXT)";
        //创建行程表
        String CREATE_TABLE_TRIP="CREATE TABLE Trip (" +
                "    trip_id      INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    trip_name    TEXT," +
                "    trip_content TEXT," +
                "    trip_time    TEXT," +
                "    id           INTEGER    REFERENCES User (id) " +
                ");";
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_TRIP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Trip.TABLE);
        onCreate(db);
    }
}
