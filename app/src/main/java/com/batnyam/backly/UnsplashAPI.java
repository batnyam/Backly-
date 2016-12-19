package com.batnyam.backly;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;

/**
 * Created by batnyam on 12/17/16.
 */
public class UnsplashAPI extends AsyncTask<String, Void, String> {
    // Constructor Function
    String data;
    String image;
    public UnsplashAPI(){

    }

    @Override
    protected String doInBackground(String... params) {
        try {
            String mainURL = "https://api.unsplash.com/photos/random?client_id=d2326752245eb781ebd153606e21f9a50ff10990030d5bf872a17927d5c3acae";
            URL callURL = new URL(mainURL);
            URLConnection urlConnection = callURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //String data;
            JSONParser jsonParser = new JSONParser();
            while ((data = in.readLine()) != null) {
                image = jsonParser.getData(data);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return new JSONParser().getData(data);
        return image;
    }
}
