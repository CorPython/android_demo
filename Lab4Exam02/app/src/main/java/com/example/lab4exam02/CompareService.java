package com.example.lab4exam02;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class CompareService extends Service {
    private Thread workThread;
    Bundle bundle = null;
    long a = 0, b = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        workThread = new Thread(null,backgroundWork,"worKThread");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        bundle = intent.getExtras();
        String str1 = bundle.getString("first");
        String str2 = bundle.getString("second");
        a = str1.equals("") ? 0 : Long.parseLong(str1);
        b = str2.equals("") ? 0 : Long.parseLong(str2);
        if(!workThread.isAlive()){
            workThread.start();
        }
    }
    private Runnable backgroundWork = new Runnable() {
        @Override
        public void run() {
            long max = IntCompare(a,b);
            MainActivity.UpdateGui(max);
            stopSelf();
        }
    };

    long IntCompare(long a,long b){
        return Math.max(a,b);
    }
}
