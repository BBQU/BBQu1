package com.example.lenovo.bbqu.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lenovo.bbqu.R;
import com.example.lenovo.bbqu.fragment.fragment4;

public class Setting extends AppCompatActivity {

    private ImageButton imageButton,imageButton2,imageButton3;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        imageButton=(ImageButton)findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imageButton2=(ImageButton)findViewById(R.id.imageButton4);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Setting.this,EditProfile.class);
                startActivity(intent);
            }
        });
        imageButton3=(ImageButton)findViewById(R.id.imageButton5);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Setting.this,PassWord.class);
                startActivity(intent);
            }
        });

        button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Setting.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
