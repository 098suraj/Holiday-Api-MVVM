package com.example.mvvmlogin.repository;

import com.example.mvvmlogin.model.Holiday;

import java.lang.annotation.Target;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("PublicHolidays/2021/us")
    Call<List<Holiday>>getHoliday();

}
