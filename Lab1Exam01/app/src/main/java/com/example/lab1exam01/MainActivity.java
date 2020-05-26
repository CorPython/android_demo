package com.example.lab1exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//设置显示的内容。
        /*private TextView tv;
    private Button bt;*/
        String TAG = "myTag";
        Log.i(TAG,"ON CREATE");
       /* //1.找到按钮，文本框
        tv=this.findViewById(R.id.textView);
        bt=this.findViewById(R.id.button);
        //2.给按钮添加点击事件
        bt.setOnClickListener(new  View.OnClickListener() {
            int count = 0;
            //获取当前文本框中的字符串
            @Override
            public void onClick(View view) {
                //使用奇偶数来控制按钮修改的文本
                if(count % 2 == 0) {
                    // 3.改文本中的文字
                    tv.setText(R.string.str2);
                }
                else
                    tv.setText(R.string.str1);
                System.out.println(count);
                count++;
            }
        });*/


    }
}
