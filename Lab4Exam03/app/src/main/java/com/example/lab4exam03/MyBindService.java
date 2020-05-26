package com.example.lab4exam03;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyBindService extends Service{

    int num1;
    int num2;


    public MyBindService(){
    }

    //先创建Service，且只会执行一次
    @Override
    public void onCreate() {
        super.onCreate();
    }
    //销毁Service
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    //执行Service，会执行很多次
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    //接触绑定，因为我们除了通过StartService可以开启Service还可以通过绑定自动创建
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
    //必须实现的方法，也是最重要的的方法
    @Override
    public IBinder onBind(Intent intent) {//IBinder是一个接口，而Binder实现了这个接口
        return new MyBinder();

    }

    public class MyBinder extends Binder{

        public int IntCompare(){//比较，返回较大值
            return Math.max(num1, num2);
        }
        public void  setData(int num1, int num2){//将Activity里的数据通过IBinder传到Service
            MyBindService.this.num1 = num1;
            MyBindService.this.num2 = num2;
        }
    }
}