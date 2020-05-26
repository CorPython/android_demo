package com.example.demostudy.ListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demostudy.ImageActivity;
import com.example.demostudy.R;


public class myAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater myLayoutInflater;
    myAdapter(Context context)
    {
        this.context = context;
        myLayoutInflater = LayoutInflater.from(context);
    }

    static class myHolder
    {
        public ImageView imageView;
        public TextView title,time,text;
    }
    @Override
    public int getCount() {
        return 4;
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
        if (convertView == null)
        {
            //使用自己自定义布局填充
            convertView = myLayoutInflater.inflate(R.layout.layout_list_view,null);
            holder = new myHolder();
            //找到布局中自己定义的控件
            holder.imageView = convertView.findViewById(R.id.image1);
            holder.title = convertView.findViewById(R.id.title);
            holder.time = convertView.findViewById(R.id.time);
            holder.text = convertView.findViewById(R.id.content);
            convertView.setTag(holder);//重要!!
        }
        else
        {
            holder = (myHolder) convertView.getTag();
        }
        //给你的控件赋值
        holder.title.setText("标题");
        holder.time.setText("2020-04-20");
        holder.text.setText("天气不错啊");
        Glide.with(context).load("http://cdn.knowempty.xyz//20200330165547.png").into(holder.imageView);
        return convertView;
    }
}
