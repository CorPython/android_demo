package com.example.lab8exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab8exam01.ListView.ListViewActivity;
import com.example.lab8exam01.sql_user.Trip;
import com.example.lab8exam01.sql_user.TripRepo;
import com.example.lab8exam01.sql_user.User;
import com.example.lab8exam01.sql_user.UserRepo;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    private EditText user_text;
    private EditText password_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_text = findViewById(R.id.edit01);
        password_text = findViewById(R.id.edit02);
    }

    public void button_login(View view) {
        UserRepo userRepo = new UserRepo(this);
        userRepo.open();
        //查询表中所有数据
        User[] users = userRepo.queryAllData();
        int len = users.length;
        if (len == 0) {
            Toast.makeText(this, "数据库数据为空", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String,String> hashMap = new HashMap<>();
        for (User user : users) {
            hashMap.put(user.name,user.password);
        }
        String name = user_text.getText().toString();//获取用户名
        String password = password_text.getText().toString();//获取密码

        if (name.equals("") || password.equals("")) {
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else {
            if (hashMap.containsKey(name) && hashMap.get(name).equals(password)) {
                Toast.makeText(this, "登录成功!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "登录失败!请检查你的用户名和密码是否输入正确!",
                        Toast.LENGTH_SHORT).show();
                return;
            }
        }
        int id = userRepo.get_id(name);
        //登录成功跳转到行程界面
        Intent intent = new Intent(this, ListViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        intent.putExtras(bundle);
        startActivityForResult(intent,Activity.RESULT_OK);
    }

    public void button_cancel(View view) {
        String name = user_text.getText().toString();//获取用户名
        String password = password_text.getText().toString();//获取密码
        if (!name.equals("") || !password.equals("")) {
            user_text.setText("");
            password_text.setText("");
        }
        Toast.makeText(this, "登录操作已取消", Toast.LENGTH_SHORT).show();
    }
}
