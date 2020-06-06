package com.example.lab8exam01.sql_user;

public class User {
    public static final String TABLE = "User";//数据库表名
    //表中各个域名
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PASSWORD= "password";

    public int user_id;//用户id
    public String name;//用户名
    public String password;//用户密码

    public User() {

    }
    //创建一个用户
    public User(int user_id, String name, String password) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
    }
}
