package com.example.mvvmlogin.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmlogin.R;
import com.example.mvvmlogin.databinding.ItemHolidayJavaBinding;
import com.example.mvvmlogin.model.Holiday;

import java.util.ArrayList;
import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder> {
    private List<Holiday> holidayList;

    public HolidayAdapter() {
        holidayList = new ArrayList<>();
    }

    public void addHolidayList(List<Holiday> currentList) {
        this.holidayList = currentList;
    }

    @NonNull
    @Override
    public HolidayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHolidayJavaBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext())
                        ,R.layout.item_holiday_java, parent, false);


        return new HolidayViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HolidayViewHolder holder, int position) {
        holder.recyclerlistBinding.setModel(holidayList.get(position));
    }

    @Override
    public int getItemCount() {
        return holidayList != null ? holidayList.size():0;
    }

    public class HolidayViewHolder extends RecyclerView.ViewHolder {
        private ItemHolidayJavaBinding  recyclerlistBinding;

        public HolidayViewHolder(@NonNull ItemHolidayJavaBinding itemView) {
            super(itemView.getRoot());
            this.recyclerlistBinding = itemView;
        }
    }
}
