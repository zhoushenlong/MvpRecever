package com.qianphone.mvprecever.http;

import android.graphics.Path;
import android.util.Log;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.qianphone.mvprecever.MyApplication;
import com.qianphone.mvprecever.model.MainModel;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 *
 * Created by 周周 on 2016/8/21.
 */
public class MainProtocol {
    public static final String path ="http://www.tngou.net/api/info/news";
    private OkHttpClient mClient = new OkHttpClient();
    MainModel.OnMainModelListener mOnMainModelListener;
    public MainProtocol(MainModel.OnMainModelListener onMainModelListener){
        mOnMainModelListener =onMainModelListener;
    }

    public void getRequestForVolley(){
        StringRequest request = new StringRequest(path, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("自定义标签", "类名==MainProtocol" + "方法名==onResponse=====:" + response);

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(MyApplication.getContext()).add(request);
    }
    public void getRequestForHttp(){
        mClient.newCall(new Request.Builder().get().url(path).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e("自定义标签", "类名==MainProtocol" + "方法名==onFailure=====:" + "数据有误");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                mOnMainModelListener.getMainJson(response.body().string());
            }
        });
    }


}
