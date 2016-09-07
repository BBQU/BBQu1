package com.example.lenovo.bbqu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.bbqu.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherRequire extends Activity {

    private String city,weather,weatherinfo;
    private EditText weathertext;
    private TextView weatherInfo;
    private Handler myHandler;
    private Thread sonThread;
    private JSONObject json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_inquire);

        weathertext = (EditText) findViewById(R.id.inputWeather);
        weatherInfo = (TextView) findViewById(R.id.displayWeatherInfo);
    }

    public void Button(View v) {

        city = weathertext.getText().toString();
        weather = "";

        myHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                weather += (String) msg.obj;
                System.out.println(weather);
                ParseJson();
            }
        };

        if(city.equals("")) {
            city = "大连";
        }

        sonThread = new MyThread();
        sonThread.start();

    }

    private void ParseJson() {

        weatherinfo = "";
        try {
            json = new JSONObject(weather);
            JSONObject resultJson = json.getJSONObject("result").getJSONObject("today");
            weatherinfo += "城市:"+resultJson.getString("city")+"\n";
            weatherinfo += "温度:"+resultJson.getString("temperature")+"\n";
            weatherinfo += "天气:"+resultJson.getString("weather")+"\n";
            weatherinfo += "风向/风力:"+resultJson.getString("wind")+"\n";
            weatherinfo += "Week:"+resultJson.getString("week")+"\n";
            weatherinfo += "温度:"+resultJson.getString("temperature")+"\n";
            weatherinfo += "日期:"+resultJson.getString("date_y")+"\n";
            weatherinfo += "穿衣指数:"+resultJson.getString("dressing_index")+"\n";
            weatherinfo += "穿衣建议:"+resultJson.getString("dressing_advice")+"\n";
            weatherinfo += "紫外线强度:"+resultJson.getString("uv_index")+"\n";
            weatherInfo.setText(weatherinfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class MyThread extends Thread {


        @Override
        public void run() {


            String urlString = "http://v.juhe.cn/weather/index?cityname="+city+"&dtype=json&format=1&key=b6f2810c3681c5bdf5998a6aa575467b";//在聚合数据申请（当前的Key不可用）

            URL url = null;

            Looper.prepare();

            try

            {
                Message myMessage = new Message();
                url = new URL(urlString);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                InputStream is = httpURLConnection.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String readerline = null;
                while ((readerline = in.readLine()) != null) {
                    myMessage.obj = readerline;
                    myHandler.sendMessage(myMessage);
                }

                httpURLConnection.disconnect();
                is.close();
                in.close();

            } catch (
                    Exception e
                    )

            {
                e.printStackTrace();
            }

            Looper.loop();


        }

    }



}
