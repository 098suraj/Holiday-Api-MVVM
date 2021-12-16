package com.example.mvvmlogin.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmlogin.model.Holiday;
import com.example.mvvmlogin.repository.HolidayRepo;

import java.util.List;

public class HolidayViewModel extends ViewModel {
    private HolidayRepo holidayRepo;
    private MutableLiveData<List<Holiday>> mutableLiveData;

    public HolidayViewModel() {
        holidayRepo = new HolidayRepo();
    }

    public LiveData<List<Holiday>> getHoliday() {
        if (mutableLiveData == null) {
            mutableLiveData = holidayRepo.requesetHolidayO();
        }
        return mutableLiveData;
    }
}
