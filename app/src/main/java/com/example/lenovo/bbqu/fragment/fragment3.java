package com.example.lenovo.bbqu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.bbqu.R;
import com.example.lenovo.bbqu.activity.MessageActivity;

/**
 * Created by lenovo on 2016/6/10.
 */
public class fragment3 extends Fragment {

    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=  inflater.inflate(R.layout.activity_fragment3,container,false);
        btn=(Button)view.findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),MessageActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
