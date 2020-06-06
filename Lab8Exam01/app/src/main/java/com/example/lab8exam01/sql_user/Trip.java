package com.example.lab8exam01.sql_user;

public class Trip {
    public static final String TABLE = "Trip";
    //表中各个域名
    public static final String KEY_ID = "id";
    public static final String KEY_TRIP_ID = "trip_id";
    public static final String KEY_TRIP_NAME = "trip_name";
    public static final String KEY_CONTENT = "trip_content";
    public static final String KEY_TIME = "trip_time";
    //表中字段对应的属性
    public int id;
    public int trip_id;
    public String trip_name;
    public String trip_content;
    public String trip_time;

    Trip() {
    }

    public Trip(int id, int trip_id, String trip_name, String trip_content, String trip_time) {
        this.id = id;
        this.trip_id = trip_id;
        this.trip_name = trip_name;
        this.trip_content = trip_content;
        this.trip_time = trip_time;
    }
}
