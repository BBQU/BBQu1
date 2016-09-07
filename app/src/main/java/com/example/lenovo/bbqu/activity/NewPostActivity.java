package com.example.lenovo.bbqu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.lenovo.bbqu.R;

public class NewPostActivity extends AppCompatActivity {


    EditText postName,mainPost,user;
    ImageButton newP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        postName=(EditText)findViewById(R.id.postName);
        mainPost=(EditText)findViewById(R.id.mainPost);
        user=(EditText)findViewById(R.id.user);
        newP=(ImageButton)findViewById(R.id.imgb1);
        newP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
