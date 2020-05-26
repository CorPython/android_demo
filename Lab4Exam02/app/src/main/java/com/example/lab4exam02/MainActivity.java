package com.example.lab4exam02;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private  EditText text_01;
    private  EditText text_02;
    private static TextView result;
    private  Button button;
    public static Handler handler = new Handler();
    int a = 0, b = 0;
    public static long maxNum = 0;

    public static void UpdateGui(long refreshDouble){
        maxNum = refreshDouble;
        handler.post(Label);
    }
    private static Runnable Label = new Runnable() {
        @Override
        public void run() {
            result.setText(String.valueOf(maxNum));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button_01);
        text_01 = findViewById(R.id.edit_01);
        text_02 = findViewById(R.id.edit_02);
        result = findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle myBundle = new Bundle();
                Intent intent = new Intent(MainActivity.this,CompareService.class);
                myBundle.putString("first",text_01.getText().toString());
                myBundle.putString("second",text_02.getText().toString());
                intent.putExtras(myBundle);
                startService(intent);
            }
        });
    }
}
