package com.example.demostudy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.demostudy.R;

public class TextViewActivity extends AppCompatActivity {
    private TextView mtv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        TextView mtv1 = findViewById(R.id.text_01);
        mtv1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
        mtv1.getPaint().setAntiAlias(true);//抗锯齿

        TextView mtv2 = findViewById(R.id.text_05);
        mtv2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
    }
}
