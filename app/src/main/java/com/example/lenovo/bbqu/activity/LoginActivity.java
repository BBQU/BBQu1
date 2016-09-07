package com.example.lenovo.bbqu.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lenovo.bbqu.R;
import com.example.lenovo.bbqu.controller.UserDBAdapter;
import com.example.lenovo.bbqu.model.User;

public class LoginActivity extends AppCompatActivity {

    private UserDBAdapter dbAdepter ;
    EditText idd,pass;
    Button login,newUser;
    ImageButton delete1,delete2;
    long i=0,p=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idd=(EditText)findViewById(R.id.id);
        pass=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.login);
        newUser=(Button)findViewById(R.id.register);
        delete1=(ImageButton)findViewById(R.id.imageButton10);
        delete2=(ImageButton)findViewById(R.id.imageButton11);
        dbAdepter = new UserDBAdapter(this);
        dbAdepter.open();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(idd.getText().length()==0){
                    Toast.makeText(v.getContext(),"请输入账号,若无账号请先注册，",Toast.LENGTH_LONG).show();
                }else{
                    if(pass.getText().length()==0){
                        Toast.makeText(v.getContext(),"请输入密码",Toast.LENGTH_LONG).show();
                    }else{
                        i = Long.parseLong(idd.getText().toString());
                        p = Long.parseLong(pass.getText().toString());
                        User[] user = dbAdepter.queryOneData(i);
                        for (int s = 0; s < user.length; s++) {
                            if (user[s].getPassWord() == p) {
                                finish();
                                Intent intent = new Intent(v.getContext(), MainActivity.class);
                                startActivity(intent);
                                break;
                            } else {
                                Toast.makeText(getApplicationContext(), "账户或密码错误", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            }
        });
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewUserActivity.class);
                startActivity(intent);
            }
        });
        delete1.setOnClickListener(deleteListener);
        delete2.setOnClickListener(deleteListener);
    }
    View.OnClickListener deleteListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            idd.setText("");
            pass.setText(null);
        }
    };
}
