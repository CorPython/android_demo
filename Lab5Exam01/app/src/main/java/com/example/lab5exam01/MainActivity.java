package com.example.lab5exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView text_size, text_color, back_color;
    EditText change_size;
    RadioGroup text_C, back_C;
    Button save;
    LinearLayout overall;
    String TextSize, TextColor, BackColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_size = findViewById(R.id.text_size);
        text_color = findViewById(R.id.text_color);
        back_color = findViewById(R.id.back_color);

        overall = findViewById(R.id.ll_01);
        change_size = findViewById(R.id.change_size);
        change_size.setKeyListener(new DigitsKeyListener(false, false));

        text_C = findViewById(R.id.text_C);
        text_C.setOnCheckedChangeListener(new TextColorChangeListener());
        back_C = findViewById(R.id.back_C);
        back_C.setOnCheckedChangeListener(new BackColorChangeListener());
        save = findViewById(R.id.save);
        save.setOnClickListener(new onClick_SaveSet());
    }

    class TextColorChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.text_black:
                    TextColor = "black";
                    break;
                case R.id.text_red:
                    TextColor = "red";
                    break;
                case R.id.text_green:
                    TextColor = "green";
                    break;
                case R.id.text_blue:
                    TextColor = "blue";
                    break;
            }
        }
    }

    class BackColorChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.back_accent:
                    BackColor = "accent";
                    break;
                case R.id.back_gray:
                    BackColor = "gray";
                    break;
                case R.id.back_white:
                    BackColor = "white";
                    break;
                case R.id.back_orange:
                    BackColor = "orange";
                    break;
            }
        }
    }

    class onClick_SaveSet implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            SharedPreferences sharedPreferences = getSharedPreferences("setting",
                    Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if("".contentEquals(change_size.getText())) {
                Toast.makeText(MainActivity.this, "ERROR:请输入要修改的字体大小！",
                        Toast.LENGTH_LONG).show();
                return;
            }
            if (Integer.parseInt(change_size.getText().toString()) > 60 ||
                    Integer.parseInt(change_size.getText().toString()) < 8) {
                Toast.makeText(MainActivity.this, "ERROR:字体大小不在修改范围内！",
                        Toast.LENGTH_LONG).show();
                return;
            }

            TextSize = change_size.getText().toString();
            editor.putString("text_size", TextSize);
            editor.putString("text_color", TextColor);
            editor.putString("back_color", BackColor);
            editor.apply();
            setting();
            Log.i("info", overall.getBackground().toString());
            Toast.makeText(MainActivity.this, "数据成功写入SharedPreferences:",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        loadSharedPreferences();
    }

    private void loadSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("setting",
                Activity.MODE_PRIVATE);
        TextSize = sharedPreferences.getString("text_size", "24");
        TextColor = sharedPreferences.getString("text_color", "black");
        BackColor = sharedPreferences.getString("back_color", "white");
        setting();

        Toast.makeText(MainActivity.this, "数据成功读取！", Toast.LENGTH_LONG).show();
    }

    private void setting() {
        //设置字体大小
        text_size.setTextSize(Integer.parseInt(TextSize));
        text_color.setTextSize(Integer.parseInt(TextSize));
        back_color.setTextSize(Integer.parseInt(TextSize));
        save.setTextSize(Integer.parseInt(TextSize));
        //设置字体颜色
        switch (TextColor) {
            case "black":
                text_size.setTextColor(Color.parseColor("#ff000000"));
                text_color.setTextColor(Color.parseColor("#ff000000"));
                back_color.setTextColor(Color.parseColor("#ff000000"));
                break;
            case "red":
                text_size.setTextColor(Color.parseColor("#ffcc0000"));
                text_color.setTextColor(Color.parseColor("#ffcc0000"));
                back_color.setTextColor(Color.parseColor("#ffcc0000"));
                break;
            case "blue":
                text_size.setTextColor(Color.parseColor("#6200EE"));
                text_color.setTextColor(Color.parseColor("#6200EE"));
                back_color.setTextColor(Color.parseColor("#6200EE"));
                break;
            case "green":
                text_size.setTextColor(Color.parseColor("#ff99cc00"));
                text_color.setTextColor(Color.parseColor("#ff99cc00"));
                back_color.setTextColor(Color.parseColor("#ff99cc00"));
                break;
        }
        //设置背景颜色
        switch (BackColor) {
            case "accent":
                overall.setBackgroundColor(Color.parseColor("#03DAC5"));
                break;
            case "orange":
                overall.setBackgroundColor(Color.parseColor("#ffffbb33"));
                break;
            case "white":
                overall.setBackgroundColor(Color.WHITE);
                break;
            case "gray":
                overall.setBackgroundColor(Color.parseColor("#00ddff"));
                break;
        }
    }

}
