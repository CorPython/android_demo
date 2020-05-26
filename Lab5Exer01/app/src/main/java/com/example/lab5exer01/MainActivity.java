package com.example.lab5exer01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.text);
    }

    public void onClick_WriteData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("test",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        sharedPreferences.getString("name", "");
        sharedPreferences.getString("habit", "");
        editor.putString("name", "karl");
        editor.putString("habit", "sleep");
        editor.putInt("number", 15);
        editor.apply();
        Toast.makeText(this, "数据成功写入SharedPreferences", Toast.LENGTH_LONG).show();
    }

    public void onClick_ReadData(View view) {
        SharedPreferences preferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
        String name = preferences.getString("name", "");
        String habit = preferences.getString("habit", "");
        int number = preferences.getInt("number",0);
        tv.setText(String.format("读取数据如下: \nname: %s \nhabit: %s", name, habit));
        Toast.makeText(this, String.format("读取数据如下: \nname: %s\nhabit: %s", name, habit),
                Toast.LENGTH_LONG).show();
    }
}
