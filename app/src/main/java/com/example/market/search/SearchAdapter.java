package com.example.market.search;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.data.Data;
import com.example.market.data.RecommendItemData;
import com.example.market.databinding.ListitemSearchNewBinding;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public interface OnClickCategoryListener {
        void onCategory(String[] tabName, Integer[] tabIcons,int position);
    }

    OnClickCategoryListener categoryListener;

    String[] trendItem = {};

    ArrayList<RecommendItemData> recommendItemDataList = new ArrayList<>();

    String[] categoryNameList = {};
    Integer[] categoryIconList = {};

    public SearchAdapter() {
    }

    public SearchAdapter(String[] trendItem, ArrayList<RecommendItemData> recommendItemDataList, String[] categoryNameList, Integer[] categoryIconList) {
        this.trendItem = trendItem;
        this.recommendItemDataList = recommendItemDataList;
        this.categoryNameList = categoryNameList;
        this.categoryIconList = categoryIconList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Data.SEARCH_RECORD) {
            ListitemSearchNewBinding binding = ListitemSearchNewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new SearchNewHolder(binding);
        } else if (viewType == Data.SEARCH_TREND) {
            ListitemSearchNewBinding binding = ListitemSearchNewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new SearchNewHolder(binding);
        } else if (viewType == Data.SEARCH_RECOMMEND) {
            ListitemSearchNewBinding binding = ListitemSearchNewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new SearchNewHolder(binding);
        } else {
            ListitemSearchNewBinding binding = ListitemSearchNewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new SearchNewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        if (viewType == Data.SEARCH_RECORD) {
            ((SearchNewHolder) holder).onBindRecord();
        } else if (viewType == Data.SEARCH_TREND) {
            ((SearchNewHolder) holder).onBindTrend(trendItem);
        } else if (viewType == Data.SEARCH_RECOMMEND) {
            ((SearchNewHolder) holder).onBindRecommend(recommendItemDataList);
        } else {
            ((SearchNewHolder) holder).onBindCategory(categoryNameList,categoryIconList,categoryListener);
        }
    }


    public void setOnClickCategoryListener(OnClickCategoryListener categoryListener) {
        this.categoryListener = categoryListener;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return Data.SEARCH_RECORD;
        } else if (position == 1) {
            return Data.SEARCH_TREND;
        } else if (position == 2) {
            return Data.SEARCH_RECOMMEND;
        } else {
            return Data.SEARCH_CATEGORY;
        }
    }

}
