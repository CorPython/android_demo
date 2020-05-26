package com.example.lab4exam01;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class CompareService extends Service {
    private final IBinder mBinder = new LocalIBinder();

    class LocalIBinder extends Binder {
        CompareService getService() {
            return CompareService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public long IntCompare(long a, long b) {
        return Math.max(a, b);
    }

}
