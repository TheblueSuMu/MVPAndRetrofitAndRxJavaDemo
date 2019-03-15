package com.lc.huluobo.mvpandretrofitandrxjavademo.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.lc.huluobo.mvpandretrofitandrxjavademo.service.entity.Book;
import com.lc.huluobo.mvpandretrofitandrxjavademo.service.manager.DataManager;
import com.lc.huluobo.mvpandretrofitandrxjavademo.service.view.BookView;
import com.lc.huluobo.mvpandretrofitandrxjavademo.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by lc on 2018/8/13.
 */

public class BookPresenter implements IBookPresenter {
    private DataManager dataManager;
    private CompositeSubscription compositeSubscription;//观察者的注册器
    private Context context;
    private BookView bookView;
    private Book book;
    private String url;


    public BookPresenter(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    @Override
    public void getSearchBooks(String name, String tag, int start, int count) {
        compositeSubscription.add(dataManager.getSearchBook(name, tag, start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onCompleted() {
                        if (book != null) {
                            bookView.onSuccess(book);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        bookView.onError("获取失败！");
                    }

                    @Override
                    public void onNext(Book book) {
                        BookPresenter.this.book = book;
                    }
                }));
    }

    @Override
    public void onCreate() {
        dataManager = new DataManager(context, url);
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        bookView = (BookView) view;
    }

    @Override
    public void attachIncommingIntent(Intent intent) {

    }
}
