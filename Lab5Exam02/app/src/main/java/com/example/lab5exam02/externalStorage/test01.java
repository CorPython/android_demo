package com.example.lab5exam02.externalStorage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5exam02.InternalStorage.test;
import com.example.lab5exam02.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test01 extends AppCompatActivity {
    public final String fileName = "study.ini";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        final EditText content = findViewById(R.id.content);
        final TextView textView = findViewById(R.id.show_content);
        Button button_read = findViewById(R.id.buttonRead);
        Button button_write = findViewById(R.id.buttonSave);
        final TextView text_ini = findViewById(R.id.text_ini);
        Button button3 = findViewById(R.id.buttonApply);
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
                String titleCount = TestConfig.getInstance(test01.this).
                        readProperties("TestGroup", "titleCount");
                String text_size = TestConfig.getInstance(test01.this).
                        readProperties("TestGroup", "size");
                String text_color = TestConfig.getInstance(test01.this).
                        readProperties("TestGroup", "textColor");
                String appName = TestConfig.getInstance(test01.this).
                        readProperties("TestGroup", "appName");
                text_ini.setText(titleCount + "\n" + text_size+"\n"+text_color+"\n"+appName);
            }
        });
    }

    private void file_save(String content) {
        FileOutputStream fileOutputStream = null;
        try {
            File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"demo");
            if(!dir.exists())
            {
                dir.mkdirs();
            }
            File file = new File(dir,fileName);
            if (!file.exists())
            {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
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

    private String fileRead()  {
        FileInputStream inputStream = null;
        try {
//            inputStream = openFileInput(fileName);
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                    +File.separator+"demo",fileName);
            inputStream = new FileInputStream(file);
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
