package com.example.lab8exam01.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab8exam01.R;
import com.example.lab8exam01.info_Activity;

public class ListViewActivity extends AppCompatActivity {
    public static final String TAG = "myTag";
    private ListView listView;
    public static int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        id = bundle.getInt("id");
        listView = findViewById(R.id.list_item);
        //设置适配器
        listView.setAdapter(new myAdapter(ListViewActivity.this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListViewActivity.this,info_Activity.class);
                Toast.makeText(ListViewActivity.this,"你点击了第"+(position+1)+"项!"
                        ,Toast.LENGTH_SHORT).show();
                finish();
                startActivity(intent);
            }
        });
    }
}
