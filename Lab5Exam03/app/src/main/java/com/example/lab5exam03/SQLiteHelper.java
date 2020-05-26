package com.example.lab5exam03;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;


public class SQLiteHelper {
    private static final String DB_NAME = "test.db";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "staff";

    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SEX = "sex";
    private static final String KEY_SALARY = "salary";
    private static final String KEY_DEPARTMENT = "department";

    private SQLiteDatabase db;
    private Context context ;
    CustomSQLiteOpenHelper helper = null;

    SQLiteDatabase getDb() {
        db = helper.getWritableDatabase();
        return db;
    }



    public SQLiteHelper(Context _context) {
        context = _context;
        helper = new CustomSQLiteOpenHelper(context);
    }

    public void open() throws SQLiteException {
        helper = new CustomSQLiteOpenHelper(context, DB_NAME, null, DB_VERSION);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }
    }

    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    public long insert(Staff staff) {
        if(queryOneData(staff._id) != null){
            return -1;
        }
        ContentValues newValues = new ContentValues();
        newValues.put(KEY_ID, staff._id);
        newValues.put(KEY_NAME, staff.name);
        newValues.put(KEY_SEX, staff.sex);
        newValues.put(KEY_DEPARTMENT, staff.department);
        newValues.put(KEY_SALARY, staff.salary);
        return db.insert(DB_TABLE, null, newValues);
    }

    public long deleteAllData() {
        return db.delete(DB_TABLE, null, null);
    }

    public long deleteOneData(long id) {
        return db.delete(DB_TABLE, KEY_ID + "=" + id, null);
    }

    public Staff[] queryAllData() {
        Cursor results =  db.query(DB_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_SEX, KEY_DEPARTMENT
                ,KEY_SALARY}, null, null, null, null,null);
        if(results.getCount() == 0) {
            Toast.makeText(this.context, "查无此人", Toast.LENGTH_SHORT).show();
        }
       return ConvertStaff(results);

    }

    public Staff[] queryOneData(long id) {
        Cursor results =  db.query(DB_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_SEX, KEY_DEPARTMENT
                ,KEY_SALARY}, KEY_ID + "=" + id, null, null
                , null, null,null);
        if(results.getCount() == 0) {
            Toast.makeText(this.context, "查无此人", Toast.LENGTH_SHORT).show();
        }
        return ConvertStaff(results);
    }

    public long updateOneData(long id, Staff staff) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, staff._id);
        values.put(KEY_NAME, staff.name);
        values.put(KEY_SEX, staff.sex);
        values.put(KEY_DEPARTMENT, staff.department);
        values.put(KEY_SALARY, staff.salary);
        return db.update(DB_TABLE, values, KEY_ID + "=" + id, null);
    }

    private Staff[] ConvertStaff(Cursor cursor) {
        int resultCounts = cursor.getCount();
        if (resultCounts == 0 || !cursor.moveToFirst()) {
            return null;
        }
        Staff[] peoples = new Staff[resultCounts];
        for (int i = 0; i < resultCounts; i++) {
            peoples[i] = new Staff();
            peoples[i]._id = cursor.getInt(0);
            peoples[i].name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
            peoples[i].sex = cursor.getString(cursor.getColumnIndex(KEY_SEX));
            peoples[i].department = cursor.getString(cursor.getColumnIndex(KEY_DEPARTMENT));
            peoples[i].salary = cursor.getFloat(cursor.getColumnIndex(KEY_SALARY));
            cursor.moveToNext();
        }
        return peoples;

    }
}



