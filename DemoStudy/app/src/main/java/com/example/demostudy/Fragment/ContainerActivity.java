package com.example.demostudy.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demostudy.R;

public class ContainerActivity extends AppCompatActivity {
    private AFragment aFragment;
    private BFragment bFragment;
    private Button btn_change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        btn_change = findViewById(R.id.button_change);

        //创建一个AFragment对象
        aFragment = new AFragment();
        //将FragmentA添加到fl_layout布局中,添加一个Commit方法
        getSupportFragmentManager().beginTransaction().add(R.id.fl_layout,aFragment).commitAllowingStateLoss();
        //创建一个BFragment对象,通过按键的点击事件跳转切换Fragment
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null)
                {
                    bFragment = new BFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_layout,bFragment).commitAllowingStateLoss();
            }
        });
    }
}
