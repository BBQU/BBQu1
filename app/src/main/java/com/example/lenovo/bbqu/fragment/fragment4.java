package com.example.lenovo.bbqu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.lenovo.bbqu.R;
import com.example.lenovo.bbqu.activity.Setting;

/**
 * Created by lenovo on 2016/6/10.
 */
public class fragment4 extends Fragment {
    ImageButton imageButton;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_fragment4,container,false);
        imageButton=(ImageButton)view.findViewById(R.id.imageButton11);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Setting.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
