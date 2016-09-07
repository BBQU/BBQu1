package com.example.lenovo.bbqu.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.bbqu.R;
import com.example.lenovo.bbqu.controller.UserDBAdapter;
import com.example.lenovo.bbqu.model.User;

public class NewUserActivity extends AppCompatActivity {

    private UserDBAdapter dbAdepter ;
    EditText idd,name,pass;
    Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        idd=(EditText)findViewById(R.id.editText6);
        name=(EditText)findViewById(R.id.editText7);
        pass=(EditText)findViewById(R.id.editText8);
        insert=(Button)findViewById(R.id.button4);
        dbAdepter = new UserDBAdapter(this);
        dbAdepter.open();
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                long i = Long.parseLong(idd.getText().toString());
                long p = Long.parseLong(pass.getText().toString());
                User user = new User(n, i, p);
                long colunm = dbAdepter.insert(user);
                if (colunm == -1) {
                    Toast.makeText(getApplicationContext(),"注册失败",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(NewUserActivity.this,LoginActivity.class);
                    startActivity(intent);

                }
            }
        });
    }
}
