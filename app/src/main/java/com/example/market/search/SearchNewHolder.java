package com.example.market.search;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.data.PreferenceManager;
import com.example.market.data.RecommendItemData;
import com.example.market.databinding.ListitemSearchNewBinding;
import com.example.market.search.category.CategoryAdapter;
import com.example.market.search.recommend.RecommendAdapter;
import com.example.market.search.record_trend.RecordTrendAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchNewHolder extends RecyclerView.ViewHolder {
    ListitemSearchNewBinding binding ;
    Context context;
    RecordTrendAdapter adapter;

    public SearchNewHolder(ListitemSearchNewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBindRecord() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2, LinearLayoutManager.HORIZONTAL,false);
        binding.rvNewRecord.setLayoutManager(gridLayoutManager);
        adapter = new RecordTrendAdapter();
        binding.rvNewRecord.setAdapter(adapter);

        Gson gson = new Gson();
        String value = PreferenceManager.get(binding.getRoot().getContext(),  "key", "[]");
        ArrayList<String> targets = gson.fromJson(value, new TypeToken<ArrayList<String>>() {}.getType());
        adapter.addAll(targets);
        adapter.notifyDataSetChanged();
    }

    public void onBindTrend(String[] trendItem){
        binding.tvSearchItem.setText("요즘 많이 찾는 검색어");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,1, LinearLayoutManager.HORIZONTAL,false);
        binding.rvNewRecord.setLayoutManager(gridLayoutManager);
        adapter = new RecordTrendAdapter();
        binding.rvNewRecord.setAdapter(adapter);

        ArrayList<String> trendItems = new ArrayList<>(Arrays.asList(trendItem));
        adapter.addAll(trendItems);
    }

    public void onBindRecommend(ArrayList<RecommendItemData> recommendItemDataList){
        binding.tvSearchItem.setText("추천 브랜드");
        RecommendAdapter adapter;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
        binding.rvNewRecord.setLayoutManager(linearLayoutManager);
        adapter = new RecommendAdapter(recommendItemDataList);
        binding.rvNewRecord.setAdapter(adapter);
    }

    public void onBindCategory(String[] categoryNameList, Integer[] categoryIconList,SearchAdapter.OnClickCategoryListener categoryListener) {
        binding.tvSearchItem.setText("인기 카테고리");

        CategoryAdapter adapter;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,4, LinearLayoutManager.VERTICAL,false);
        binding.rvNewRecord.setLayoutManager(gridLayoutManager);
        adapter = new CategoryAdapter(categoryNameList,categoryIconList);
        adapter.setOnClickCategoryListener(categoryListener);
        binding.rvNewRecord.setAdapter(adapter);
    }
}

