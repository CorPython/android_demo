package com.example.lab5exam03;

import androidx.annotation.NonNull;

public class Staff {
     int _id = -1;
     String name;
     String sex;
     String department;
     float salary;

    public Staff() {
    }

    public Staff(int _id, String name, String sex, String department, float salary) {
        this._id = _id;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.salary = salary;
    }

    @NonNull
    @Override
    public String toString() {
        String result = "";
        result += "_id：" + this._id + " ";
        result += "姓名：" + this.name + " ";
        result += "性别：" + this.sex + " ";
        result += "小区：" + this.department + " ";
        result += "薪资：" + this.salary + " ";
        return result;
    }

}
