package com.example.lab8exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab8exam01.ListView.ListViewActivity;
import com.example.lab8exam01.sql_user.Trip;
import com.example.lab8exam01.sql_user.TripRepo;

public class info_Activity extends AppCompatActivity {
    public static final String TAG = "111";
    EditText user_id,trip_id,trip_name,trip_time,trip_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_);
        user_id = findViewById(R.id.user_id);
        trip_id = findViewById(R.id.trip_id);
        trip_name = findViewById(R.id.trip_name);
        trip_content = findViewById(R.id.trip_content);
        trip_time = findViewById(R.id.trip_time);
    }

    public void delete(View view) {
        int id = Integer.parseInt(user_id.getText().toString());
        int Trip_id = Integer.parseInt(trip_id.getText().toString());
        TripRepo tripRepo = new TripRepo(this);
        tripRepo.open();
        if(tripRepo.deleteOneData(Trip_id,id) == -1)
        {
            Toast.makeText(this, "不存在这个行程!无法删除!", Toast.LENGTH_SHORT).show();
            return;
        }
        tripRepo.close();
        Intent  intent = new Intent(this, ListViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        intent.putExtras(bundle);
        startActivityForResult(intent, Activity.RESULT_OK);
    }

    public void save(View view) {
        int id = Integer.parseInt(user_id.getText().toString());
        int Trip_id = Integer.parseInt(trip_id.getText().toString());
        String name = trip_name.getText().toString();
        String content = trip_content.getText().toString();
        String time = trip_time.getText().toString();
        TripRepo tripRepo = new TripRepo(this);
        tripRepo.open();
        if(tripRepo.insert(new Trip(id,Trip_id,name,content,time)) == -1)
        {
            Toast.makeText(this,"插入失败,和主键发生冲突",Toast.LENGTH_SHORT).show();
            return;
        }
        tripRepo.close();
        Intent  intent = new Intent(this, ListViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        intent.putExtras(bundle);
        startActivityForResult(intent, Activity.RESULT_OK);
    }

    public void update(View view) {
        int id = Integer.parseInt(user_id.getText().toString());
        int Trip_id = Integer.parseInt(trip_id.getText().toString());
        String name = trip_name.getText().toString();
        String content = trip_content.getText().toString();
        String time = trip_time.getText().toString();
        TripRepo tripRepo = new TripRepo(this);
        tripRepo.open();
        if(tripRepo.updateOneData(Trip_id,new Trip(id,Trip_id,name,content,time)) == -1)
        {
            Toast.makeText(this, "不存在这个行程!无法更新", Toast.LENGTH_SHORT).show();
            return;
        }
        tripRepo.close();
        Intent  intent = new Intent(this, ListViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        intent.putExtras(bundle);
        startActivityForResult(intent, Activity.RESULT_OK);
    }
}
