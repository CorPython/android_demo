package com.example.lab6exam01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.read);
        final TextView view = findViewById(R.id.show);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String res = getHtmlContent("http://t.weather.sojson.com/api/weather/city/101240101");
                    if (!res.equals(""))
                    {
                        StringBuilder builder = new StringBuilder("");
                        ArrayList<String> ret = Analysis(res);
                        for (String i : ret)
                        {
                            builder.append(i + "\n");
                        }
                        view.setText(builder.toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    //从指定网址获取json数组
    public static String getHtmlContent(String url) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String htmlCode = null;
        StringBuffer resultBuffer = new StringBuffer();
        HttpGet request = new HttpGet(url);
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(request);
            if(response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = response.getEntity();
                BufferedReader io = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));
                String strResult;
                while((strResult = io.readLine())!=null){
                    resultBuffer.append(strResult);
                }
                htmlCode = new String(resultBuffer);
                io.close();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return htmlCode;
    }

    private static ArrayList<String> Analysis(String jsonStr)
            throws JSONException {
        ArrayList<String> strings = new ArrayList<>();
        //最外层
        JSONObject jsonObjectAll = new JSONObject(jsonStr);
        //获取data
        String data = jsonObjectAll.optString("data", null);

        if(!TextUtils.isEmpty(data))
        {
            JSONObject jsonObject = new JSONObject(data); //获取到data对象
            String  forecast =jsonObject.optString("forecast", null);//获取到forecast数据
            JSONArray array = new JSONArray(forecast);//json对象数组
            //对象数组中的内容,即天气数据
            for (int i = 1; i < 4; i++) {
                // JSON数组里面的具体-JSON对象
                JSONObject jsonObjectOne = array.getJSONObject(i);
                String ymd = jsonObjectOne.optString("ymd", null);
                String week = jsonObjectOne.optString("week",null);
                String type = jsonObjectOne.optString("type", null);
                String high = jsonObjectOne.optString("high", null);
                String low = jsonObjectOne.optString("low", null);
                String notice = jsonObjectOne.optString("notice",null);
                StringBuilder builder  = new StringBuilder("");
                strings.add(builder.append(ymd + " " +week+" "+type + " "+ high+ " " + low +" "+ notice).toString());
            }

        }
        return strings;
    }
}
