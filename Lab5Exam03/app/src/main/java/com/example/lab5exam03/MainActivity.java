package com.example.lab5exam03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton, select, insert,delete;
    private EditText edit, edit02;
    private TextView text;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.btn1);
        mButton.setOnClickListener(this);
        select = findViewById(R.id.btn2);
        select.setOnClickListener(this);
        text = findViewById(R.id.text);
        insert = findViewById(R.id.btn3);
        insert.setOnClickListener(this);
        delete = findViewById(R.id.btn4);
        delete.setOnClickListener(this);
        edit = findViewById(R.id.edit);
        edit02 = findViewById(R.id.edit01);
    }

    @Override
    public void onClick(View v) {
        SQLiteHelper helper = new SQLiteHelper(this);
        switch (v.getId()) {
            case R.id.btn1:
                db = helper.getDb();
                break;
            case R.id.btn2://查询语句
                helper.open();
                Staff[] res = null;
                StringBuilder all = new StringBuilder();
                if (edit.getText().toString().equals("")) {
                    res = helper.queryAllData();
                    for (Staff i : res) {
                        all.append(i.toString() + "\n");
                    }
                    text.setText(all.toString());
                } else {
                    int id = Integer.parseInt(edit.getText().toString());
                    res = helper.queryOneData(id);
                    if (res != null) {
                        text.setText(res[0].toString());
                    }
                }
                break;
            case R.id.btn3://插入语句
                helper.open();
                Staff all_staff[] = new Staff[4];
                all_staff[0] = new Staff(5, "sss", "xx", "cvs", 1200);
                all_staff[1] = new Staff(6, "sss", "xx", "cvs", 1200);
                all_staff[2] = new Staff(7, "s52ss", "xx", "cvs", 1200);
                all_staff[3] = new Staff(4, "32sss", "xx", "cvs", 1200);
                for (Staff i : all_staff) {
                    if (helper.queryOneData(i._id) != null) {
                        Toast.makeText(this, "该主键已经存在", Toast.LENGTH_SHORT).show();
                    } else {
                        long code = helper.insert(i);
                    }
                }
                break;
            case R.id.btn4:
                helper.open();
                if (edit02.getText().toString().equals("")) {
                } else {
                    int id = Integer.parseInt(edit02.getText().toString());
                    if (helper.queryOneData(id) != null)
                        helper.deleteOneData(id);
                    else
                        Toast.makeText(this,"sorry!该id不存在,删除失败!",Toast.LENGTH_SHORT).show();
                }
            default:
                break;
        }
    }

}