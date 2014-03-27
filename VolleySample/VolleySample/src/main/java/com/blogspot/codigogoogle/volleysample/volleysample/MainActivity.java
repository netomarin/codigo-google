package com.blogspot.codigogoogle.volleysample.volleysample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity implements Response.ErrorListener, Response.Listener<String> {

    private TextView textView;
    private EditText textEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEditText = (EditText) findViewById(R.id.textEditText);
        textView = (TextView) findViewById(R.id.wordsCountTextView);
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countWords();
            }
        });
    }

    private void countWords() {
        String url = WebCommons.WS_HOST+WebCommons.WS_PATH_WORD_COUNTER;
        StringRequest strReq = new StringRequest(Request.Method.POST, url, this, this) {

            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("text", textEditText.getText().toString());

                return params;
            }
        };
        VolleySampleApplication app = (VolleySampleApplication) getApplication();
        app.getRequestQueue().add(strReq);
    }

    private void updateWordsCount(int words) {
        textView.setText(Integer.toString(words));
    }

    @Override
    public void onResponse(String s) {
        if (s != null) {
            try {
                JSONObject jsonObject = new JSONObject(s);
                if (jsonObject != null) {
                    int words = jsonObject.getInt("words");
                    updateWordsCount(words);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
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
}