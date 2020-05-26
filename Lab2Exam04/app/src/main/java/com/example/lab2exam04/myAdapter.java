package com.example.lab2exam04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class myAdapter extends ArrayAdapter {

    private int ImageId;

    public myAdapter(Context context, int headImage, List<myBean> obj) {
        super(context, headImage, obj);
        ImageId = headImage;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        myBean myBean = (myBean) getItem(position);
        View view;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(ImageId, parent, false);
            viewHolder.fruitImage = view.findViewById(R.id.headimage);
            viewHolder.fruitName = view.findViewById(R.id.textview01);
            viewHolder.fruitMsg = view.findViewById(R.id.textview02);
            viewHolder.fruitLayout = view.findViewById(R.id.ViewAll);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.fruitImage.setImageResource(myBean.getImageID());
        viewHolder.fruitName.setText(myBean.getName());
        viewHolder.fruitMsg.setText(myBean.getMsg());
        /*viewHolder.fruitLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "你点击了第" + position + "项" + "你选择" + radiotext, Toast.LENGTH_SHORT).show();
            }
        });*/
        return view;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        TextView fruitMsg;
        LinearLayout fruitLayout;
    }
}