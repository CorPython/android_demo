package com.example.demostudy.Jump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.demostudy.R;

public class B_Activity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_);
        textView = findViewById(R.id.text_03);
        button = findViewById(R.id.button_04);
        //之前使用的是Bundle传递数据,现在接受的之后解开的也是bundle
        final Bundle bundle = getIntent().getExtras();
        String str = bundle.getString("name");
        int number = bundle.getInt("number");
        textView.setText(str + ',' +  number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击button返回键后返回一些数据
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("info",textView.getText().toString());
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }


}
