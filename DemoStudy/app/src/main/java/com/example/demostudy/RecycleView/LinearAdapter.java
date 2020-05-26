package com.example.demostudy.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demostudy.R;


public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearHolder> {
    private Context mcontext;
    LinearAdapter(Context context)
    {
        this.mcontext = context;
    }

    @NonNull
    @Override
    public LinearAdapter.LinearHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearHolder(LayoutInflater.from(mcontext).inflate(R.layout.linear_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearHolder holder, int position) {
            holder.textView.setText(R.string.text01);
    }

    @Override
    public int getItemCount() {
        return 15;
    }
    class LinearHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public LinearHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
        }
    }
}
