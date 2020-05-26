package com.example.uitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView和button
        tv = findViewById(R.id.text);
        Button bt = findViewById(R.id.button);
        bt.setOnClickListener(this);
        //spinner组件
        Spinner spinner = findViewById(R.id.spinner01);
        List<String> li = new ArrayList<>();
        li.add("1111");
        li.add("2222");
        li.add("3333");
        li.add("4444");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,li);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    /*public void myClick(View view) {
        if(count % 2 == 0) {
            tv.setText(R.string.first);
            count++;
        }
        else {
            tv.setText(R.string.second);
            count++;
        }
    }*/

    @Override
    public void onClick(View v) {
        if(count % 2 == 0) {
            tv.setText(R.string.first);
            count++;
        }
        else {
            tv.setText(R.string.second);
            count++;
        }
    }
}
