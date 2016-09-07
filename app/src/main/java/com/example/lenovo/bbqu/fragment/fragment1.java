package com.example.lenovo.bbqu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.lenovo.bbqu.R;
import com.example.lenovo.bbqu.activity.BanActivity;
import com.example.lenovo.bbqu.activity.WeatherRequire;
import com.example.lenovo.bbqu.activity.checkActivity;

/**
 * Created by lenovo on 2016/6/10.
 */
public class fragment1 extends Fragment {

    ImageButton check,btn6;
    RadioButton radioC;
    TextView checkk,ban;
    //定义ViewFlipper，
    private ViewFlipper flipper;
    private int[] resId = {R.drawable.b44, R.drawable.b22, R.drawable.b11};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment1,container,false);

        check=(ImageButton)view.findViewById(R.id.btn2);
        radioC=(RadioButton)view.findViewById(R.id.radioC);
        btn6=(ImageButton)view.findViewById(R.id.btn6);
        checkk=(TextView)view.findViewById(R.id.textView3);
        ban=(TextView)view.findViewById(R.id.textView7);
        checkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),checkActivity.class);
                startActivity(intent);
            }
        });
        ban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),BanActivity.class);
                startActivity(intent);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),checkActivity.class);
                startActivity(intent);
            }
        });
        radioC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),WeatherRequire.class);
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),BanActivity.class);
                startActivity(intent);
            }
        });
        flipper = (ViewFlipper) view.findViewById(R.id.flipper);
        //动态导入的方式为ViewFlipper加入子View
        for (int i = 0; i < resId.length; i++) {
            flipper.addView(getImageView(resId[i]));
        }

        //为ViewFlipper去添加动画效果
        flipper.setInAnimation(getContext(), R.anim.left_in);
        flipper.setOutAnimation(getContext(), R.anim.left_out);
        //为ViewFlipper设定视图切换的时间间隔
        flipper.setFlipInterval(2000);
        //开始播放
        flipper.startFlipping();

        return view;
    }
    //添加图片信息
    private ImageView getImageView(int resId) {
        ImageView image = new ImageView(getContext());
        image.setBackgroundResource(resId);
        return image;
    }
}
