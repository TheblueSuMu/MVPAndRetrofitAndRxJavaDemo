package com.lc.huluobo.mvpandretrofitandrxjavademo.service.presenter;

/**
 * Created by lc on 2018/8/13.
 */

public interface IBookPresenter extends Presenter {
    void getSearchBooks(String name, String tag, int start, int count);
}
