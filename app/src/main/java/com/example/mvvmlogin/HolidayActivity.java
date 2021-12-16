package com.example.mvvmlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmlogin.Adapter.HolidayAdapter;
import com.example.mvvmlogin.databinding.ActivityHolidayBinding;
import com.example.mvvmlogin.model.Holiday;
import com.example.mvvmlogin.repository.MyApplications;
import com.example.mvvmlogin.viewModel.HolidayViewModel;

import java.util.List;

public class HolidayActivity extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();
    ActivityHolidayBinding binding;
    HolidayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_holiday);
        initUI();


        HolidayViewModel holidayViewModel = new HolidayViewModel();
        holidayViewModel.getHoliday().observe(this, new Observer<List<Holiday>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(List<Holiday> currencyPojos) {
                if (currencyPojos != null && !currencyPojos.isEmpty()) {
                    Log.e(TAG, "observe onChanged()=" + currencyPojos.size());
                    adapter.addHolidayList(currencyPojos);
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

    void initUI() {
        binding.rvHolidayList.setHasFixedSize(true);
        binding.rvHolidayList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HolidayAdapter();
        binding.rvHolidayList.setAdapter(adapter);
    }

}
