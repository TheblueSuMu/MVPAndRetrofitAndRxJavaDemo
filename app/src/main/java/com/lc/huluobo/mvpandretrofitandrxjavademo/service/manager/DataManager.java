package com.lc.huluobo.mvpandretrofitandrxjavademo.service.manager;

import android.content.Context;

import com.lc.huluobo.mvpandretrofitandrxjavademo.service.RetrofitHelper;
import com.lc.huluobo.mvpandretrofitandrxjavademo.service.RetrofitService;
import com.lc.huluobo.mvpandretrofitandrxjavademo.service.entity.Book;

import rx.Observable;

/**
 * Created by lc on 2018/8/13.
 */

public class DataManager {
    private RetrofitService retrofitService;

    public DataManager(Context context, String url) {
        this.retrofitService = RetrofitHelper.getInstance(context, url).getService();
    }

    public Observable<Book> getSearchBook(String name, String tag, int start, int count) {
        return retrofitService.getSearchBook(name, tag, start, count);
    }

}
