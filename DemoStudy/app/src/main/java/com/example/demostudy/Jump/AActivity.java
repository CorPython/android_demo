package com.example.demostudy.Jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demostudy.R;

public class AActivity extends AppCompatActivity {
    private Button button;
    private String Acreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(Acreate,"A create!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.显式跳转1
                Intent intent = new Intent(AActivity.this,B_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","张三");
                bundle.putInt("number",151);
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent,0);
                //2.显式跳转2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,B_Activity.class);
//                startActivity(intent);
                //3.显示跳转3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.example.demostudy.Jump.B_Activity");
//                startActivity(intent);
                //4.显示跳转
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.example.demostudy.Jump.B_Activity"));
//                startActivity(intent);
                //隐式调用
//                Intent intent = new Intent();
//                intent.setAction("com.example.demostudy.Jump");
//                startActivity(intent);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("info"),Toast.LENGTH_SHORT).show();
    }
}
