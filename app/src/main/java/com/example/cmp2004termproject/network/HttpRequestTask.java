package com.example.cmp2004termproject.network;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestTask extends AsyncTask<String, Void, String> {

    private onHttpResultListener listener;
    private Exception error;

    public interface onHttpResultListener {
        void onSuccess(String result);
        void onError(Exception e);
    }

    public HttpRequestTask(onHttpResultListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... urls) {
        if (urls == null || urls.length == 0) {
            error = new Exception("No URL provided");
            return null;
        }

        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
                );
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString();
            } else {
                error = new Exception("HTTP Error: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            error = e;
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (listener != null) {
            if (result != null) {
                listener.onSuccess(result);
            } else {
                listener.onError(error != null ? error : new Exception("Unknown error"));
            }
        }
    }
}