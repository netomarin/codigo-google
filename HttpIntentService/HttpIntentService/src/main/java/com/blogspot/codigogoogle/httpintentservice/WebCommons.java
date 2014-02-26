package com.blogspot.codigogoogle.httpintentservice;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by netomarin on 26/02/14.
 */
public class WebCommons {

    public static final String WS_HOST = "http://codigogdemos.appspot.com";
    public static final String WS_PATH_WORD_COUNTER = "/wordCounter";

    private WebCommons() {}

    public static HttpURLConnection postRequest(String host, String path, Map<String, Object> params) throws MalformedURLException {

        String urlString = host;
        if (path != null && path.length() > 0)
            urlString += path;

        URL url = new URL(urlString);
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setUseCaches (false);
            connection.connect();

            if (params != null && params.size() > 0) {
                String urlParameters = createParams(params);
                DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
                wr.writeBytes(urlParameters);
                wr.flush();
                wr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }

    private static String createParams(Map<String, Object> paramsMap) {
        StringBuilder paramsData = new StringBuilder();
        for (Map.Entry<String,Object> param : paramsMap.entrySet()) {
            if (paramsData.length() != 0) paramsData.append('&');
            try {
                paramsData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                paramsData.append('=');
                paramsData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }

        return paramsData.toString();
    }

    public static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}