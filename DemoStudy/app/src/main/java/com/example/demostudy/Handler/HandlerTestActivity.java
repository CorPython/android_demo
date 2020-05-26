package com.example.demostudy.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.demostudy.R;

public class HandlerTestActivity extends AppCompatActivity {
    private Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);
        /*handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HandlerTestActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        },3000);*/
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what)
                {
                    case 1:
                        Toast.makeText(HandlerTestActivity.this,"线程通信成功!",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        }.start();
    }
}
