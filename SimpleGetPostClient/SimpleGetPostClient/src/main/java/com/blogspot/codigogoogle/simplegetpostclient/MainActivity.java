package com.blogspot.codigogoogle.simplegetpostclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class MainActivity extends ActionBarActivity {

    private static final String PROGRESS_DIALOG_FRAGMENT_TAG = "PROGRESS_DIALOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        TextView resultTextView;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ((Button) rootView.findViewById(R.id.getButton)).setOnClickListener(this);
            ((Button) rootView.findViewById(R.id.postButton)).setOnClickListener(this);
            resultTextView = (TextView) rootView.findViewById(R.id.resultTextView);

            return rootView;
        }

        void showProgressDialogFragment() {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            Fragment prev = getActivity().getSupportFragmentManager().findFragmentByTag(PROGRESS_DIALOG_FRAGMENT_TAG);
            if (prev != null)
                ft.remove(prev);

            ProgressDialogFragment progressDialog = ProgressDialogFragment.newInstance();
            progressDialog.show(ft, PROGRESS_DIALOG_FRAGMENT_TAG);
        }

        void dismissProgressDialogFragment() {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            Fragment prev = getActivity().getSupportFragmentManager().findFragmentByTag(PROGRESS_DIALOG_FRAGMENT_TAG);
            if (prev != null) {
                ft.remove(prev);
                ft.commit();
            }
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.getButton)
                doGet();
            else if (v.getId() == R.id.postButton)
                doPost();
        }

        private void doPost() {
            AsyncTask<Void, Void, String> postTask = new AsyncTask<Void, Void, String>() {

                @Override
                protected void onPreExecute() {
                    showProgressDialogFragment();
                }

                @Override
                protected String doInBackground(Void... params) {
                    HttpResponse response = null;
                    try {
                        response = WebCommons.doPost(WebCommons.WS_SCHEME, WebCommons.WS_HOST,
                                WebCommons.WS_PORT, WebCommons.WS_PATH_SIMPLE_GET_POST, null);
                        return EntityUtils.toString(response.getEntity());
                    } catch (URISyntaxException e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        return null;
                    } catch (IOException e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(String s) {
                    resultTextView.setText(s);
                    dismissProgressDialogFragment();
                }
            };
            postTask.execute();
        }

        private void doGet() {
            AsyncTask<Void, Void, String> getTask = new AsyncTask<Void, Void, String>() {
                @Override
                protected void onPreExecute() {
                    showProgressDialogFragment();
                }

                @Override
                protected String doInBackground(Void... params) {
                    HttpResponse response = null;
                    try {
                        response = WebCommons.doGet(WebCommons.WS_SCHEME, WebCommons.WS_HOST,
                                WebCommons.WS_PORT, WebCommons.WS_PATH_SIMPLE_GET_POST, null);
                        return EntityUtils.toString(response.getEntity());
                    } catch (URISyntaxException e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        return null;
                    } catch (IOException e) {
                        Log.e(getClass().getName(), e.getMessage(), e);
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(String s) {
                    resultTextView.setText(s);
                    dismissProgressDialogFragment();
                }
            };
            getTask.execute();
        }
    }
}