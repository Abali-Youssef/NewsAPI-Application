package com.ex.appapi.services;

import com.ex.appapi.models.ListNews;
import com.ex.appapi.models.News;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestServiceAPI {

    @GET("v2/everything/")
    Call<ListNews> listNewsByKey(@Query("q") String word, @Query("from") String date, @Query("apikey") String key);
}
