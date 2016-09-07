package com.example.lenovo.bbqu.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.bbqu.R;
import com.example.lenovo.bbqu.model.postView;

public class PostDetailActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        TextView postName=(TextView)findViewById(R.id.postName);
        TextView mainPost=(TextView)findViewById(R.id.mainPost);
        TextView user=(TextView)findViewById(R.id.user);
        btn=(Button)findViewById(R.id.button2);
        postView postv=(postView)getIntent().getExtras().get("intent_object");
        StringBuffer pnsb=new StringBuffer();
        pnsb.append(postv.getPostName());
        StringBuffer mpsb=new StringBuffer();
        mpsb.append(postv.getMainPost());
        StringBuffer usb=new StringBuffer();
        usb.append(postv.getUser());
        postName.setText(pnsb.toString());
        mainPost.setText(mpsb.toString());
        user.setText(usb.toString());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PostDetailActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
    }
    public void finish(View view){

        finish();
    }

}
