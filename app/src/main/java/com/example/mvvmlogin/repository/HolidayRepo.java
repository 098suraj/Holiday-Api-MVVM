package com.example.mvvmlogin.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmlogin.model.Holiday;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidayRepo {
    private final String TAG = getClass().getSimpleName();

    public MutableLiveData<List<Holiday>> requesetHolidayO() {
        final MutableLiveData<List<Holiday>> mutableLiveDat = new MutableLiveData<>();
        ApiInterface apiInterface = MyApplications.getRetrofit().create(ApiInterface.class);
        apiInterface.getHoliday().enqueue(new Callback<List<Holiday>>() {
            @Override
            public void onResponse(Call<List<Holiday>> call, Response<List<Holiday>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mutableLiveDat.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Holiday>> call, Throwable t) {

            }
        });
        return mutableLiveDat;
    }
}
