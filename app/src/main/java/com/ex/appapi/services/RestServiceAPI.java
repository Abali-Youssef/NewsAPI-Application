package com.ex.appapi.services;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestServiceAPI {

    @GET("/")
    Call<RestServiceAPI> listNewsByKey(@Query("q") String word, @Query("from") Date date, @Query("apikey") String key);

}
