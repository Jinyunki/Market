package com.example.market.search.recommend;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.market.data.RecommendItemData;
import com.example.market.databinding.ListitemRecommendBinding;

import java.util.ArrayList;

public class RecommendHolder extends RecyclerView.ViewHolder {
    ListitemRecommendBinding binding;

    public RecommendHolder(ListitemRecommendBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(int position, ArrayList<RecommendItemData> recommendItemDataList) {
        RecommendItemData recommendItemData = recommendItemDataList.get(position);
        Glide.with(binding.getRoot()).load(recommendItemData.getImageUri()).into(binding.ivBrandLogo);
        binding.tvBrandName.setText(recommendItemData.getBrandName());
        binding.tvBrandCount.setText(recommendItemData.getBrandCount());

        if (position != recommendItemDataList.size() - 1) {
            binding.btBrandAll.setVisibility(View.GONE);
        } else {
            binding.btBrandAll.setVisibility(View.VISIBLE);
            binding.btBrandAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "브랜드 모두보기", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
