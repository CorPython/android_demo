package com.example.lab2exer03;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HelloWorld extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button01);
        button.setOnClickListener(buttonListener);
    }
    private OnClickListener buttonListener = new OnClickListener(){
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "You have clicked a button!",Toast.LENGTH_LONG).show();
        }
    };
}

