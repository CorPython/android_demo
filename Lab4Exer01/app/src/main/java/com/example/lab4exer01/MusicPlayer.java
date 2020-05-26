package com.example.lab4exer01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicPlayer extends AppCompatActivity {
    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        Button start = findViewById(R.id.start);
        Button stop = findViewById(R.id.stop);
        start.setOnClickListener(new StartListener());
        stop.setOnClickListener(new StopListener());

    }

    private class StartListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(flag) {
                Intent intent = new Intent();
                intent.setAction("android.media");
                intent.setPackage(getPackageName());
                startService(intent);
                flag = false;
            }

        }
    }

    private class StopListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction("android.media");
            intent.setPackage(getPackageName());
            stopService(intent);
            flag = true;
        }
    }
}
