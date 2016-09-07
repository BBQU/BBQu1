package com.example.lenovo.bbqu.activity;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.bbqu.*;
import com.example.lenovo.bbqu.model.Package;
import com.example.lenovo.bbqu.controller.GetAndParseJsonPost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class checkActivity extends AppCompatActivity {

    EditText company,number;
    Button check,clean;
    TextView datetime,remark;
    ListView listPackageView;
    private List<Package> listPackage;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what) {
                case GetAndParseJsonPost.PARSESUCCWSS:
                    listPackage =(List<Package>) msg.obj;
                    show();
                    Toast.makeText(getApplicationContext(), "连接成功", Toast.LENGTH_SHORT).show();
                    break;
                case GetAndParseJsonPost.FAILL:
                    Toast.makeText(getApplicationContext(),"连接失败",Toast.LENGTH_SHORT).show();
                    break;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        datetime=(TextView)findViewById(R.id.datetime);
        remark=(TextView)findViewById(R.id.remark);
        company=(EditText)findViewById(R.id.company);
        number=(EditText)findViewById(R.id.number);
        check=(Button)findViewById(R.id.check);
        clean=(Button)findViewById(R.id.clearn);
        listPackageView=(ListView)findViewById(R.id.listView);
        final String[] companyNames=getResources().getStringArray(R.array.company);
        final String[] comNo=getResources().getStringArray(R.array.comno);
        final GetAndParseJsonPost getAndParseJsonPost=new GetAndParseJsonPost(mHandler);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mcompany, mnumber;
                mcompany = company.getText().toString();
                mnumber = number.getText().toString();
                for (int i = 0; i < companyNames.length; i++) {
                    if (mcompany.equals(companyNames[i])) {
                        mcompany = comNo[i];
                    }
                }
                getAndParseJsonPost.getAddress(mcompany, mnumber);
                getAndParseJsonPost.getJsonFromInternet();
            }
        });
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndParseJsonPost.clean();
                company.setText("");
                number.setText("");
            }
        });
    }
    private void show() {
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (Package aPackage : listPackage) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("datetime", aPackage.getDatetime());
            item.put("remark", aPackage.getRemark());
            items.add(item);

        }
        final MyAdapter adapter = new MyAdapter(this, items, R.layout.listpackage,
                new String[]{ "datetime", "remark"}, new int[]{R.id.datetime, R.id.remark});
        listPackageView.setAdapter(adapter);
    }
    class MyAdapter extends SimpleAdapter {
        public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);

            return view;
        }
    }
    public void finish(View view){

        finish();
    }
}
