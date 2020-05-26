package com.example.lab3exer01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.lab3exer01.R.id.edit_text_02;

public class test extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView textView = findViewById(edit_text_02);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String name = b.getString("name");
        textView.setText(name);
    }
}
