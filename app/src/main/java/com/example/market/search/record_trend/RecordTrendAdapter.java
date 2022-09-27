package com.example.market.search.record_trend;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemRecordBinding;

import java.util.ArrayList;


public class RecordTrendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<String> dataList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListitemRecordBinding binding = ListitemRecordBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RecordHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RecordHolder) holder).onBind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addAll(ArrayList<String> dataList){
        this.dataList.clear();
        this.dataList.addAll(dataList);
    }
}
