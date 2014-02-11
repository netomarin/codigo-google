package com.blogspot.codigogoogle.simplegetpostclient;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by netomarin on 07/02/14.
 */
public class WebCommons {

    public static final String WS_SCHEME = "http";
    public static final String WS_HOST = "codigogdemos.appspot.com";
    public static final int WS_PORT = 80;
    public static final String WS_PATH_SIMPLE_GET_POST = "/simpleGetPost";

    private WebCommons() {
    }

    public static HttpResponse doGet(String scheme, String host, int port, String path,
                                     List<NameValuePair> params) throws URISyntaxException {
        URI uri = URIUtils.createURI(scheme, host, port, path, params == null ? null : URLEncodedUtils.format(params, "UTF-8"), null);

        HttpGet get = new HttpGet(uri);
        DefaultHttpClient hc = new DefaultHttpClient();
        HttpResponse response = null;

        try {
            response = hc.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static HttpResponse doPost(String scheme, String host, int port, String path,
                                      List<NameValuePair> params) throws URISyntaxException {
        URI uri = URIUtils.createURI(scheme, host, port, path, null, null);

        HttpPost post = new HttpPost(uri);
        if (params != null && !params.isEmpty()) {
            try {
                post.setEntity(new UrlEncodedFormEntity(params));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        DefaultHttpClient hc = new DefaultHttpClient();
        HttpResponse response = null;
        try {
            response = hc.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}