package com.example.lab6exer01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().
                permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Button bt = findViewById(R.id.button01);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpClient httpClient = new DefaultHttpClient();
                String httpUrl = "http://169.254.116.188:8080/WEB_war_exploded/loginUser.jsp";
                HttpPost post = new HttpPost(httpUrl);
                //(1).创建参数
                String username = ((EditText)findViewById(R.id.editText1)).getText().toString();
                String password = ((EditText)findViewById(R.id.edit_Text2)).getText().toString();
                ArrayList<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair("username",username));
                params.add(new BasicNameValuePair("password",password));
                try {
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"utf-8");
                    post.setEntity(entity);
                    HttpResponse response = httpClient.execute(post);
                    String result = "";
                    if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
                    {
                        result = EntityUtils.toString(response.getEntity(),"utf-8");
                    }
                    else{
                        result = "读取的内容为null";
                    }
                    TextView view = findViewById(R.id.textView);
                    view.setText(result);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                httpClient.getConnectionManager().shutdown();
            }
        });


    }
}
