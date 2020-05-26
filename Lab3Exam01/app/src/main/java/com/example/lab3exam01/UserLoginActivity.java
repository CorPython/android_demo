package com.example.lab3exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UserLoginActivity extends AppCompatActivity {

    private EditText editText;
    private String TAG = "UserLoginActivity";
    private EditText edit02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        Button button09 = findViewById(R.id.button09);//提交
        Button button10 = findViewById(R.id.button10);//取消
        editText = findViewById(R.id.edit01);//用户名
        edit02 = findViewById(R.id.edit02);//密码
        final String error_info1 = "用户名中不能出现“@”符号!";//错误信息1
        final String error_info2 = "用户名长度不能超过12个字符!"; //错误信息2
        editText.addTextChangedListener(new TextWatcher() {
            String temp = "";
            String illegalChar = "@";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                temp = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editText.setSelection(s.length());
            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = s.toString();
                if (string.equals(temp)) {
                    return;
                }
                StringBuilder stringBuffer = new StringBuilder();
                for (int i = 0; i < string.length(); i++) {
                    if (illegalChar.indexOf(string.charAt(i)) < 0) {
                        stringBuffer.append(string.charAt(i));
                    } else {
                        //如果尝试输入@符号,会出现错误信息1
                        Toast.makeText(UserLoginActivity.this, error_info1, Toast.LENGTH_SHORT).show();
                    }
                }
                temp = stringBuffer.toString();
                //如果字符串长度超过12,只取前12个字符,输出错误信息2
                if (temp.length() > 12) {
                    temp = temp.substring(0, 13);
                    Toast.makeText(UserLoginActivity.this, error_info2, Toast.LENGTH_SHORT).show();
                }
                editText.setText(temp);
            }
        });
        button09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                String password = edit02.getText().toString();
                String msg = "用户名:" + str + "密码:" + password;
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("hello", msg);
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "你已取消登录操作!";
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("hello", msg);
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }
}
