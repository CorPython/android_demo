package com.example.demostudy.RecycleView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.demostudy.R;

public class LinearRecycleActivity extends AppCompatActivity {
    private RecyclerView mRvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycle);
        mRvMain = findViewById(R.id.mainView);
        mRvMain.addItemDecoration(new myDecoration());
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecycleActivity.this));
        mRvMain.setAdapter(new LinearAdapter(LinearRecycleActivity.this));
    }
    //绘制边框的下边缘
    class myDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}

