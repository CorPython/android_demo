package com.example.lab4exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText text_01;
    private EditText text_02;
    private TextView result;
    private Button stop;
    private boolean isBind = false;
    private CompareService mService = new CompareService();
    long a = 0, b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button_01);
        text_01 = findViewById(R.id.edit_01);
        text_02 = findViewById(R.id.edit_02);
        result = findViewById(R.id.result);
        stop = findViewById(R.id.button_02);
        //取消绑定
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBind)
                {
                    isBind = false;
                    unbindService(connection);
                    mService = null;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进行绑定
                if (!isBind) {
                    Intent serviceIntent = new Intent(MainActivity.this,
                            CompareService.class);
                    //绑定服务
                    bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE);
                    isBind = true;
                }
                String c1 = text_01.getText().toString();
                String c2 = text_02.getText().toString();
                if (!c1.equals("") || !c2.equals("")) {
                    a = c1.equals("")? 0 : Long.parseLong(c1);
                    b = c2.equals("")? 0 : Long.parseLong(c2);
                }
                result.setText(String.valueOf(mService.IntCompare(a, b)));
            }
        });
    }
    //建立服务链接
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //获得Service实例
            mService = ((CompareService.LocalIBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };

}
