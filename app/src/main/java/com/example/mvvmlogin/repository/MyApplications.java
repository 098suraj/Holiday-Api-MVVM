package com.example.mvvmlogin.repository;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MyApplications extends Application {
    final String TAG=getClass().getSimpleName();
    private static MyApplications minstance;
    private static Retrofit retrofit=null;

    @Override
    public void onCreate() {
        super.onCreate();
        minstance=this;
    }

    public  static Retrofit getRetrofit(){
        if (retrofit == null) {
            okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder().build();

            retrofit = new Retrofit.Builder()
                    .client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.Base_Url)
                    .build(); }
return retrofit;
    }
}
