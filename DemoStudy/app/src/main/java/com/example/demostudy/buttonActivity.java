package com.example.demostudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class buttonActivity extends AppCompatActivity {
    private Button button;
    private TextView tv01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        button = findViewById(R.id.btn03);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(buttonActivity.this,getString(R.string.click_button3),Toast.LENGTH_SHORT).show();
            }
        });
        tv01 = findViewById(R.id.text_07);
        tv01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(buttonActivity.this,getString(R.string.click_text),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ToastClick(View view) {
        Toast.makeText(this,getString(R.string.click_button4),Toast.LENGTH_SHORT).show();
    }

}
