package com.example.market.search.record_trend;

import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemRecordBinding;

public class RecordHolder extends RecyclerView.ViewHolder {
    ListitemRecordBinding binding;


    public RecordHolder(ListitemRecordBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(String text) {
        this.binding.tvRecordList.setText(text);
    }
}
