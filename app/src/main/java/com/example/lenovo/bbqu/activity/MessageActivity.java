package com.example.lenovo.bbqu.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.bbqu.R;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesage);
    }
    public void start3(View view){
        EditText phoneNumber=(EditText)findViewById(R.id.editText3);
        String phonenumber=phoneNumber.getText().toString();
        EditText SmsContent=(EditText)findViewById(R.id.editText4);
        String smscontent=SmsContent.getText().toString();
        SmsManager sms= SmsManager.getDefault();
        PendingIntent pi= PendingIntent.getActivity(this, 0, new Intent(this, MessageActivity.class), 0);
        if(smscontent.length()>70) {
            ArrayList<String> msgs = sms.divideMessage(smscontent);
            for (String msg : msgs) {
                sms.sendTextMessage(phonenumber, null, msg, pi, null);
            }
        } else {
            sms.sendTextMessage(phonenumber, null, smscontent, pi, null);
        }
        Toast.makeText(MessageActivity.this, "短信发送完成", Toast.LENGTH_SHORT).show();


    }
    public void finish(View view){

        finish();
    }

}
