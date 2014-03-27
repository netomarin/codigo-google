package com.blogspot.codigogoogle.httpintentservice;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by netomarin on 26/02/14.
 */
public class HttpIntentService extends IntentService {

    public static final String STR_EXTRA_TEXT = "TEXT";
    public static final String RESULT_RECEIVER_EXTRA = "RESULT_RECEIVER";

    public HttpIntentService() {
        super("HttpIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ResultReceiver resultReceiver = intent.getParcelableExtra(RESULT_RECEIVER_EXTRA);
        String text = intent.getStringExtra(STR_EXTRA_TEXT);
        Map<String, Object> params = new LinkedHashMap<String, Object>();

        if (text != null) {
            params.put("text", text);
        }

        try {
            HttpURLConnection connection = WebCommons.postRequest(WebCommons.WS_HOST,
                    WebCommons.WS_PATH_WORD_COUNTER, params);
            if (connection != null && connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String response = WebCommons.getStringFromInputStream(connection.getInputStream());
                if (resultReceiver != null) {
                    Bundle resultBundle = new Bundle();
                    resultBundle.putString("result", response);
                    resultReceiver.send(Activity.RESULT_OK, resultBundle);
                }
            }
        } catch (MalformedURLException e) {
            Log.e("HttpIntentService", e.getMessage());
        } catch (IOException e) {
            Log.e("HttpIntentService", e.getMessage());
        }
    }
}