package com.example.lab8exam01.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lab8exam01.R;
import com.example.lab8exam01.sql_user.Trip;
import com.example.lab8exam01.sql_user.TripRepo;


public class myAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater myLayoutInflater;

    myAdapter(Context context) {
        this.context = context;
        myLayoutInflater = LayoutInflater.from(context);
    }

    static class myHolder {
        ImageView imageView;
        TextView trip_id, trip_name, trip_time, trip_content;
    }

    @Override
    public int getCount() {
        TripRepo tripRepo = new TripRepo(this.context);
        tripRepo.open();
        Trip[] trips = tripRepo.queryOneData(ListViewActivity.id);
        tripRepo.close();
        return trips.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        myHolder holder = null;
        if (convertView == null) {
            //使用自己自定义布局填充
            convertView = myLayoutInflater.inflate(R.layout.layout_list_view, null);
            holder = new myHolder();
            //找到布局中自己定义的控件
            holder.imageView = convertView.findViewById(R.id.image1);
            holder.trip_id = convertView.findViewById(R.id.trip_id);
            holder.trip_name = convertView.findViewById(R.id.trip_name);
            holder.trip_time = convertView.findViewById(R.id.trip_time);
            holder.trip_content = convertView.findViewById(R.id.trip_content);
            convertView.setTag(holder);//重要!!
        } else {
            holder = (myHolder) convertView.getTag();
        }
        TripRepo tripRepo = new TripRepo(this.context);
        tripRepo.open();
        Trip[] trips = tripRepo.queryOneData(ListViewActivity.id);
        for (int i = 0; i < getCount(); i++) {
            if (position == i) {
                //给你的控件赋值
                holder.trip_id.setText(String.valueOf(trips[i].trip_id));
                holder.trip_name.setText(String.valueOf(trips[i].trip_name));
                holder.trip_time.setText(String.valueOf(trips[i].trip_time));
                holder.trip_content.setText(String.valueOf(trips[i].trip_content));
                Glide.with(context).load("https://uploadbeta.com/api/pictures/random/?key=BingEverydayWallpaperPicture").into(holder.imageView);
            }
        }
        tripRepo.close();
        return convertView;
    }
}
