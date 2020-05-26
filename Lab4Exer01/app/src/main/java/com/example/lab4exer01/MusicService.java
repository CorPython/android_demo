package com.example.lab4exer01;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    private MediaPlayer Player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Player = MediaPlayer.create(this,R.raw.test1);
        Player.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Player.stop();
    }


}
