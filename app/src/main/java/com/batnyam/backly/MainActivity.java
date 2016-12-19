package com.batnyam.backly;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    final UnsplashAPI api = new UnsplashAPI();
    String jsonStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            jsonStr = api.execute().get();
            Log.i("data", jsonStr);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}