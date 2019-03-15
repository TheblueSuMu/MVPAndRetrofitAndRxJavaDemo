package com.lc.huluobo.mvpandretrofitandrxjavademo.service;

import com.lc.huluobo.mvpandretrofitandrxjavademo.service.entity.Book;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lc on 2018/8/13.
 */

public interface RetrofitService {
    @GET("book/search")
    Observable<Book> getSearchBook(@Query("q") String name,
                                   @Query("tag") String tag,
                                   @Query("start") int start,
                                   @Query("count") int count);
}
