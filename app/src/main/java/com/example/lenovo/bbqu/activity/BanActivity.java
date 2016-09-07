package com.example.lenovo.bbqu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.lenovo.bbqu.R;


public class BanActivity extends AppCompatActivity {
   ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban);
        imageButton=(ImageButton)findViewById(R.id.imgb1);

        }

    public void finish(View view){

            finish();
    }

}

