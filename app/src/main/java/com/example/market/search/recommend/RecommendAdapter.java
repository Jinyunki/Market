package com.example.market.search.recommend;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.data.RecommendItemData;
import com.example.market.databinding.ListitemRecommendBinding;

import java.util.ArrayList;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendHolder> {
    ArrayList<RecommendItemData> recommendItemDataList = new ArrayList<>();

    public RecommendAdapter(ArrayList<RecommendItemData> recommendItemDataList) {
        this.recommendItemDataList = recommendItemDataList;
    }

    @NonNull
    @Override
    public RecommendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListitemRecommendBinding binding = ListitemRecommendBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RecommendHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendHolder holder, int position) {
        holder.onBind(position,recommendItemDataList);
    }

    @Override
    public int getItemCount() {
        return recommendItemDataList.size();
    }
}
