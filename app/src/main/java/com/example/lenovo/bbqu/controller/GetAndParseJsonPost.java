package com.example.lenovo.bbqu.controller;

import android.os.Handler;
import android.os.Message;

import com.example.lenovo.bbqu.model.Package;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/6/10.
 */
public class GetAndParseJsonPost {
    private String url="http://v.juhe.cn/exp/index?key=2a65f83fac80d7019dcca7396cdd3d72&com=";
    public static final int PARSESUCCWSS=0x2001;
    public static final int FAILL=00;
    private Handler handler;
    public void getAddress(String company,String packageNumber){
        url=url+company+"&no="+packageNumber;
    }
    public void clean(){
        url="http://v.juhe.cn/exp/index?key=2a65f83fac80d7019dcca7396cdd3d72&com=";
    }
    public GetAndParseJsonPost(Handler handler) {
        // TODO Auto-generated constructor stub
        this.handler=handler;
    }
    public void getJsonFromInternet () {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setRequestMethod("GET");
                    if (conn.getResponseCode()==200) {
                        InputStream inputStream=conn.getInputStream();  //创建一个输入流
                        List<Package> listPackage =parseJson(inputStream);
                        if (listPackage.size()>0) {
                            Message msg=new Message();
                            msg.what=PARSESUCCWSS;//通知UI线程Json解析完成
                            msg.obj= listPackage;//将解析出的数据传递给UI线程
                            handler.sendMessage(msg);
                        }

                    }else{Message msg=new Message();
                        msg.what=FAILL;}

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();

    }
    protected List<Package> parseJson(InputStream inputStream) {
        // TODO Auto-generated method stub
        List<Package> listPackage = new ArrayList<Package>();
        byte [] jsonBytes = convertIsToByteArray(inputStream);  //将输入流转换为字节数组
        String json = new String(jsonBytes);
        System.out.println("JSON内容："+json);
        try {
            JSONObject jObject = new JSONObject(json);  //实例化

            JSONObject jObject1=jObject.getJSONObject("result");
            JSONArray jsonArray=jObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject arrayObject=jsonArray.getJSONObject(i);
            String datetime=arrayObject.getString("datetime");
            String remark = arrayObject.getString("remark");
            Package news=new Package(datetime, remark);
            listPackage.add(news);
            }
        }
        catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listPackage;
    }
    private byte[] convertIsToByteArray(InputStream inputStream) {
        // TODO Auto-generated method stub
        ByteArrayOutputStream baos=new ByteArrayOutputStream(); //字节数组的输出流
        byte buffer[]=new byte[1024];
        int length=0;
        try {
            while ((length=inputStream.read(buffer))!=-1) {
                baos.write(buffer, 0, length);
            }
            inputStream.close();//关闭输入流
            baos.flush();//刷新缓存
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
}
