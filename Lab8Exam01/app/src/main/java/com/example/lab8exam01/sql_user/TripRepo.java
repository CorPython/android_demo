package com.example.lab8exam01.sql_user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

public class TripRepo {
    private DBHelper dbHelper;
    private Context context;
    public SQLiteDatabase db;


    public TripRepo(Context context) {
        this.context = context;
        dbHelper = new DBHelper(this.context);
    }

    public void open() throws SQLiteException {
        dbHelper = new DBHelper(this.context);
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

    public int insert(Trip trip) {
        if (queryInsertData(trip.trip_id) != null) {
            return -1;//主键已存在,不能插入
        }
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Trip.KEY_ID, trip.id);
        values.put(Trip.KEY_TRIP_ID, trip.trip_id);
        values.put(Trip.KEY_TRIP_NAME, trip.trip_name);
        values.put(Trip.KEY_TIME, trip.trip_time);
        values.put(Trip.KEY_CONTENT, trip.trip_content);
        return (int) db.insert(Trip.TABLE, null, values);
    }


    public Trip[] queryOneData(long id) {
        Cursor results = db.query(Trip.TABLE, new String[]{Trip.KEY_TRIP_ID,
                        Trip.KEY_TRIP_NAME, Trip.KEY_TIME, Trip.KEY_CONTENT, Trip.KEY_ID}, Trip.KEY_ID + "=" + id, null, null
                , null, Trip.KEY_TIME, null);
        if (results.getCount() == 0 || !results.moveToFirst()) {
            //Toast.makeText(this.context, "查无此人", Toast.LENGTH_SHORT).show();
        }
        return ConvertTrip(results);
    }

    public Trip[] queryInsertData(long id) {
        Cursor results = db.query(Trip.TABLE, new String[]{Trip.KEY_TRIP_ID,
                        Trip.KEY_TRIP_NAME, Trip.KEY_TIME, Trip.KEY_CONTENT, Trip.KEY_ID}, Trip.KEY_TRIP_ID + "=" + id, null, null
                , null, Trip.KEY_TIME, null);
        if (results.getCount() == 0 || !results.moveToFirst()) {
            //Toast.makeText(this.context, "查无此人", Toast.LENGTH_SHORT).show();
        }
        return ConvertTrip(results);
    }

    public Trip[] delete_data(long id,long id1) {
        Cursor results = db.query(Trip.TABLE, new String[]{Trip.KEY_TRIP_ID,
                        Trip.KEY_TRIP_NAME, Trip.KEY_TIME, Trip.KEY_CONTENT, Trip.KEY_ID}, Trip.KEY_TRIP_ID + "=" + id  +
                        " and " + Trip.KEY_ID + "=" + id1, null, null
                , null, Trip.KEY_TIME, null);
        return ConvertTrip(results);
    }

    public Trip[] queryAllData() {
        Cursor results = db.query(Trip.TABLE, new String[]{Trip.KEY_TRIP_ID,
                        Trip.KEY_TRIP_NAME, Trip.KEY_TIME, Trip.KEY_CONTENT, Trip.KEY_ID}, null, null
                , null, null, Trip.KEY_TIME);
        if (results.getCount() == 0) {
            //Toast.makeText(this.context, "查无此人", Toast.LENGTH_SHORT).show();
        }
        return ConvertTrip(results);
    }

    private Trip[] ConvertTrip(Cursor cursor) {
        int resultCounts = cursor.getCount();
        if (resultCounts == 0 || !cursor.moveToFirst()) {
            return null;
        }
        Trip[] trips = new Trip[resultCounts];
        for (int i = 0; i < resultCounts; i++) {
            trips[i] = new Trip();
            trips[i].trip_id = cursor.getInt(cursor.getColumnIndex(Trip.KEY_TRIP_ID));
            trips[i].trip_name = cursor.getString(cursor.getColumnIndex(Trip.KEY_TRIP_NAME));
            trips[i].trip_content = cursor.getString(cursor.getColumnIndex(Trip.KEY_CONTENT));
            trips[i].trip_time = cursor.getString(cursor.getColumnIndex(Trip.KEY_TIME));
            trips[i].id = cursor.getInt(cursor.getColumnIndex(Trip.KEY_ID));
            cursor.moveToNext();
        }
        return trips;
    }
    //根据trip_id删除表中的数据
    public long deleteOneData(long id,long id1) {
        if(delete_data(id,id1) == null){
            return -1;
        }
        return db.delete(Trip.TABLE, Trip.KEY_TRIP_ID + "=" + id +
                        " and " + Trip.KEY_ID + "=" + id1, null);
    }
    //根据trip_id更新数据
    public long updateOneData(long id, Trip trip) {
        if(queryOneData(trip.trip_id) == null){
            return -1;
        }
        ContentValues values = new ContentValues();
        values.put(Trip.KEY_ID, trip.id);
        values.put(Trip.KEY_TRIP_ID, trip.trip_id);
        values.put(Trip.KEY_TIME,trip.trip_time);
        values.put(Trip.KEY_CONTENT,trip.trip_content );
        values.put(Trip.KEY_TRIP_NAME,trip.trip_name);
        Toast.makeText(this.context, "插入成功!", Toast.LENGTH_SHORT).show();
        return db.update(Trip.TABLE, values,  Trip.KEY_TRIP_ID+ "=" + id, null);
    }

}

