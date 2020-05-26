package com.example.lab2exam05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.NumberKeyListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView editText = findViewById(R.id.editText);
    }
}
