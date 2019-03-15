package com.lc.huluobo.mvpandretrofitandrxjavademo.service.view;

import com.lc.huluobo.mvpandretrofitandrxjavademo.service.entity.Book;

/**
 * Created by lc on 2018/8/13.
 */

public interface BookView extends View {
    void onSuccess(Book book);

    void onError(String error);
}
