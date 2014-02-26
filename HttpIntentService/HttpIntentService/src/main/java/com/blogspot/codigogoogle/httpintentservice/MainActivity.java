package com.blogspot.codigogoogle.httpintentservice;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends ActionBarActivity {

    private TextView textView;
    private EditText textEditText;
    private IntentServiceResultReceiver resultReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        resultReceiver = new IntentServiceResultReceiver(new Handler());

        textEditText = (EditText) findViewById(R.id.textEditText);
        textView = (TextView) findViewById(R.id.wordsCountTextView);
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countWords();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void countWords() {
        Intent serviceIntent = new Intent(this, HttpIntentService.class);
        serviceIntent.putExtra(HttpIntentService.RESULT_RECEIVER_EXTRA, resultReceiver);
        serviceIntent.putExtra(HttpIntentService.STR_EXTRA_TEXT, textEditText.getText().toString());
        startService(serviceIntent);
    }

    private void updateWordsCount(int words) {
        textView.setText(Integer.toString(words));
    }

    private class IntentServiceResultReceiver extends ResultReceiver {

        /**
         * Create a new ResultReceive to receive results.  Your
         * {@link #onReceiveResult} method will be called from the thread running
         * <var>handler</var> if given, or from an arbitrary thread if null.
         *
         * @param handler
         */
        public IntentServiceResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            String result = resultData.getString("result");
            try {
                if (result != null && !result.equals("null")) {
                    JSONObject resultJSON = new JSONObject(result);
                    updateWordsCount(resultJSON.getInt("words"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}