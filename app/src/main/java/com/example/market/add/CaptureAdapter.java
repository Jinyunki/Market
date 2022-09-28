package com.example.market.add;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemCaptureBinding;

public class CaptureAdapter extends RecyclerView.Adapter<CaptureHolder> {

    @NonNull
    @Override
    public CaptureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListitemCaptureBinding binding = ListitemCaptureBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CaptureHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CaptureHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 12;
    }
}
