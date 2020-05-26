package com.example.lab5exam02.InternalStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lab5exam02.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test extends AppCompatActivity {
    public final String fileName = "study.ini";
    EditText content;
    TextView textView;
    Button button_read;
    Button button_write;
    Button button3;
    TextView text_ini;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        content = findViewById(R.id.content);
        textView = findViewById(R.id.show_content);
        button_read = findViewById(R.id.buttonRead);
        button_write = findViewById(R.id.buttonSave);
        text_ini = findViewById(R.id.text_ini);
        button3 = findViewById(R.id.buttonApply);
        linearLayout = findViewById(R.id.ll_01);
        button_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file_save(content.getText().toString());
            }
        });
        button_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(fileRead());
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                settting();
            }
        });

    }
    private void settting() {
        String titleCount = TestConfig.getInstance(test.this).
                readProperties("TestGroup", "titleCount");
        String text_size = TestConfig.getInstance(test.this).
                readProperties("TestGroup", "size");
        String text_color = TestConfig.getInstance(test.this).
                readProperties("TestGroup", "textColor");
        String appName = TestConfig.getInstance(test.this).
                readProperties("TestGroup", "appName");
        String BackColor = TestConfig.getInstance(test.this).
                readProperties("TestGroup", "backColor");
        text_ini.setText(titleCount + "\n" + text_size + "\n" + text_color + "\n" + appName);
        //设置字体大小
        text_ini.setTextSize(Integer.parseInt(text_size));
        textView.setTextSize(Integer.parseInt(text_size));
        //设置字体颜色
        switch (text_color) {
            case "black":
                text_ini.setTextColor(Color.parseColor("#ff000000"));
                textView.setTextColor(Color.parseColor("#ff000000"));
                break;
            case "red":
                text_ini.setTextColor(Color.parseColor("#ffcc0000"));
                textView.setTextColor(Color.parseColor("#ffcc0000"));
                break;
            case "blue":
                text_ini.setTextColor(Color.parseColor("#6200EE"));
                textView.setTextColor(Color.parseColor("#6200EE"));
                break;
            case "green":
                text_ini.setTextColor(Color.parseColor("#ff99cc00"));
                textView.setTextColor(Color.parseColor("#ff99cc00"));
                break;
        }
        //设置背景颜色
        switch (BackColor) {
            case "accent":
                linearLayout.setBackgroundColor(Color.parseColor("#03DAC5"));
                break;
            case "orange":
                linearLayout.setBackgroundColor(Color.parseColor("#ffffbb33"));
                break;
            case "white":
                linearLayout.setBackgroundColor(Color.WHITE);
                break;
            case "gray":
                linearLayout.setBackgroundColor(Color.parseColor("#00ddff"));
                break;
        }

    }

    private void file_save(String content) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String fileRead() {
        FileInputStream inputStream = null;
        try {
            inputStream = openFileInput(fileName);
            byte[] buff = new byte[1024];
            StringBuilder builder = new StringBuilder("");
            int len = 0;
            while (true) {
                try {
                    if (!((len = inputStream.read(buff)) > 0)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                builder.append(new String(buff, 0, len));
            }
            return builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }


}
