package com.example.lab4exam03;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab4exam03.MyBindService.MyBinder;

public class MainActivity extends Activity {
    TextView tv;
    Button bt;
    Intent intent;
    EditText ed1;
    EditText ed2;
    MyBinder binder;
    int num1 = 0, num2 = 0;
    //为绑定服务的参数
    ServiceConnection conn = new ServiceConnection() {
        //最精华的部分，就是把安插在Service里的间谍iBinder找过来获取或者传递数据
        @Override
        public void onServiceConnected(ComponentName arg0, IBinder iBinder) {
            binder = (MyBinder) iBinder;

        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            // TODO Auto-generated method stub

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件
        ed1 = findViewById(R.id.edit_01);
        ed2 = findViewById(R.id.edit_02);
        tv = findViewById(R.id.ret);
        bt = findViewById(R.id.button_01);
        intent = new Intent(this, MyBindService.class);
        //绑定服务，这里的Intent和onstartCommand参数里的intent是同一个，所以我们也能通过这种方式
        //向Service传递数据
        this.bindService(intent, conn, BIND_AUTO_CREATE);
        String str1 = ed1.getText().toString();
        String str2 = ed2.getText().toString();
        if(!str1.equals("") && !str2.equals("")) {
            num1 = Integer.parseInt(ed1.getText().toString());
            num2 = Integer.parseInt(ed2.getText().toString());
        }
    }

    /*
     * 异步类的三个参数
     * 第一个表示执行doInBackground方法传进来的参数类型
     * 第二个是进度值的类型
     * 第三个是执行完任务返回的类型，也就是onPostExecute的参数类型
     */
    class MyAsynvTask extends AsyncTask<Integer, Void, Integer> {

        //执行一些任务前的UI操作
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer i) {//UI操作，将textview的内容设置成最大值
            tv.setText(String.valueOf(i));
        }

        @Override
        protected Integer doInBackground(Integer... num) {//返回最大值到onPostExecute（）
            binder.setData(num[0], num[1]);
            return binder.IntCompare();
        }


    }

    public void click(View view) {
        Toast.makeText(this, "11111", Toast.LENGTH_SHORT).show();
        new MyAsynvTask().execute(num1, num2);//启动异步，类似thread.start()方法，
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}