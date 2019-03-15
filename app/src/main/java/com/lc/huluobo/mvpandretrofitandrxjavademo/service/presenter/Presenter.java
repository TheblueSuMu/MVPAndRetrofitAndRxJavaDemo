package com.lc.huluobo.mvpandretrofitandrxjavademo.service.presenter;

import android.content.Intent;

import com.lc.huluobo.mvpandretrofitandrxjavademo.service.view.View;

/**
 * Created by lc on 2018/8/13.
 */

public interface Presenter {
    void onCreate();

    void onStart();//用不上

    void onStop();

    void pause();//用不上

    void attachView(View view);

    void attachIncommingIntent(Intent intent);
}
