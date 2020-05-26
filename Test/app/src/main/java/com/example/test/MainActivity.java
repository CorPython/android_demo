package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* View tv = this.findViewById(R.id.textView2);
        final String str = tv.toString();
        Button bt0 = this.findViewById(R.id.button0);
        Button bt1 = this.findViewById(R.id.button1);
        Button bt2 = this.findViewById(R.id.button2);
        Button bt3 = this.findViewById(R.id.button3);
        Button bt4 = this.findViewById(R.id.button4);
        Button bt5 = this.findViewById(R.id.button5);
        Button bt6 = this.findViewById(R.id.button6);
        Button bt7 = this.findViewById(R.id.button7);
        Button bt8 = this.findViewById(R.id.button8);
        Button bt9 = this.findViewById(R.id.button9);

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(str);
            }
        });*/

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
    /*  void register(Button bt)
    {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.concat(value)
            }
        });
    }*/
}
