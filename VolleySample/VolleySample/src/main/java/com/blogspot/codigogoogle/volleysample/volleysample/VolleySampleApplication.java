package com.blogspot.codigogoogle.volleysample.volleysample;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by netomarin on 27/03/14.
 */
public class VolleySampleApplication extends Application {

    private RequestQueue queue;

    @Override
    public void onCreate() {
        this.queue = Volley.newRequestQueue(this);
    }

    public RequestQueue getRequestQueue() {
        return queue;
    }
}