package com.example.demostudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demostudy.Fragment.ContainerActivity;
import com.example.demostudy.Handler.HandlerTestActivity;
import com.example.demostudy.Jump.AActivity;
import com.example.demostudy.ListView.ListViewActivity;
import com.example.demostudy.RecycleView.RecycleViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button mbtTextView;
    private Button button01;
    private Button mbtEditView;
    private Button mbtJump;
    private Button MbtImageView;
    private Button MbtListView;
    private Button mbtRecycleView;
    private Button handlerView;
    private Button FragmentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testconponent);
        mbtTextView = findViewById(R.id.button01);
        button01 = findViewById(R.id.button02);
        mbtEditView = findViewById(R.id.button03);
        mbtJump = findViewById(R.id.button04);
        MbtImageView = findViewById(R.id.button05);
        MbtListView = findViewById(R.id.button06);
        mbtRecycleView = findViewById(R.id.button07);
        handlerView = findViewById(R.id.button08);
        FragmentView= findViewById(R.id.button09);
        SetListeners();
    }

    private void SetListeners() {
        OnClick onClick = new OnClick();
        mbtTextView.setOnClickListener(onClick);
        button01.setOnClickListener(onClick);
        mbtEditView.setOnClickListener(onClick);
        mbtJump.setOnClickListener(onClick);
        MbtImageView.setOnClickListener(onClick);
        MbtListView.setOnClickListener(onClick);
        mbtRecycleView.setOnClickListener(onClick);
        handlerView.setOnClickListener(onClick);
        FragmentView.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.button01:
                    //跳转到TextView的界面
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.button02:
                    //跳转到button的界面
                    intent = new Intent(MainActivity.this, buttonActivity.class);
                    break;
                case R.id.button03:
                    //跳转到登录界面
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    break;
                case R.id.button04:
                    //跳转到AActivity界面
                    intent = new Intent(MainActivity.this, AActivity.class);
                    break;
                case R.id.button05:
                    //跳转到ImageActivity界面
                    intent = new Intent(MainActivity.this, ImageActivity.class);
                    break;
                case R.id.button06:
                    //跳转到ListViewActivity界面
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.button07:
                    //跳转到RecycleViewActivity界面
                    intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                    break;
                case R.id.button08:
                    //跳转到HandlerTest界面
                    intent = new Intent(MainActivity.this, HandlerTestActivity.class);
                    break;
                case R.id.button09:
                    //跳转到Fragment容器
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
