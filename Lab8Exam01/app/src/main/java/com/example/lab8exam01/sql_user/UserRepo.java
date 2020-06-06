package com.example.lab8exam01.sql_user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

public class UserRepo {
    private DBHelper dbHelper;
    private Context context;
    public SQLiteDatabase db;

    public UserRepo(Context context){
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLiteException {
        dbHelper = new DBHelper(context);
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = dbHelper.getReadableDatabase();
        }
    }

    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }
    public int insert(User user){
        if(queryOneData(user.user_id) != null )
        {
            return -1;//主键已存在,不能插入
        }
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.KEY_ID,user.user_id);
        values.put(User.KEY_NAME,user.name);
        values.put(User.KEY_PASSWORD,user.password);
        return (int) db.insert(User. TABLE,null,values);
    }

    public User[] queryOneData(long id) {

        Cursor results =  db.query(User.TABLE, new String[] {User.KEY_ID,User.KEY_NAME,User.KEY_PASSWORD}, User.KEY_ID + "=" + id, null, null
                , null, null,null);
        if(results.getCount() == 0) {
            //Toast.makeText(this.context, "查无此人", Toast.LENGTH_SHORT).show();
        }
        return ConvertUser(results);
    }

    public int get_id(String name){
        Cursor results =  db.query(User.TABLE, new String[] {User.KEY_ID}, User.KEY_NAME + "=?" , new String[]{name}, null
                , null, null,null);
        if(results.getCount() == 0) {
            //Toast.makeText(this.context, "查无此人", Toast.LENGTH_SHORT).show();
        }
        results.moveToNext();
        return results.getInt(0);
    }

    public User[] queryAllData() {
        Cursor results =  db.query(User.TABLE, new String[] {User.KEY_ID,User.KEY_NAME,User.KEY_PASSWORD}, null, null
                , null, null,null);
        if(results.getCount() == 0) {
            //Toast.makeText(this.context, "查无此人", Toast.LENGTH_SHORT).show();
        }
        return ConvertUser(results);
    }

    private User[] ConvertUser(Cursor cursor) {
        int resultCounts = cursor.getCount();
        if (resultCounts == 0 || !cursor.moveToFirst()) {
            return null;
        }
        User[] users = new User[resultCounts];
        for (int i = 0; i < resultCounts; i++) {
            users[i] = new User();
            users[i].user_id = cursor.getInt(0);
            users[i].name = cursor.getString(cursor.getColumnIndex(User.KEY_NAME));
            users[i].password = cursor.getString(cursor.getColumnIndex(User.KEY_PASSWORD));
            cursor.moveToNext();
        }
        return users;
    }

}
