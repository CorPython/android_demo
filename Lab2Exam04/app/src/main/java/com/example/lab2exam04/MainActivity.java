package com.example.lab2exam04;



import android.os.Bundle;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<myBean> myBeanList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.ListView);
        init();
        myAdapter adapter = new myAdapter(MainActivity.this,R.layout.my,myBeanList);
        listView.setAdapter(adapter);
    }
    private void init(){
        myBean bean1 = new myBean("张三","赶紧去听罗老师讲课",R.drawable.img1);
        myBeanList.add(bean1);

        myBean bean2 = new myBean("Jerry","吃完饭一起打游戏",R.drawable.img2);
        myBeanList.add(bean2);

        myBean bean3 = new myBean("班级群","@全体成员,下午我们开个班会",R.drawable.img3);
        myBeanList.add(bean3);
    }
}
