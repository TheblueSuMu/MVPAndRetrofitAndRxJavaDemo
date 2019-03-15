package com.lc.huluobo.mvpandretrofitandrxjavademo.service;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lc on 2018/8/13.
 */

public class RetrofitHelper {
    private Context context;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(new
            GsonBuilder()
            .create());
    @SuppressLint("StaticFieldLeak")
    private static RetrofitHelper instance = null;
    private Retrofit retrofit = null;
    private String url;

    private RetrofitHelper(Context context, String baseUrl) {
        this.context = context;
        this.url = baseUrl;
        init();
    }

    private void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    public RetrofitService getService() {
        return retrofit.create(RetrofitService.class);
    }

    public static synchronized RetrofitHelper getInstance(Context context, String baseUrl) {
        if (instance == null) {
            instance = new RetrofitHelper(context, baseUrl);
        }
        return instance;
    }
}