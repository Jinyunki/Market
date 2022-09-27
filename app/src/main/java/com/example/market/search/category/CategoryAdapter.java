package com.example.market.search.category;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemCategoryBinding;
import com.example.market.home.HomeRecyclerViewAdapter;
import com.example.market.search.SearchAdapter;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<Integer> iconList = new ArrayList<>();

    String[] categoryName = {};
    Integer[] categoryIcon = {};
    SearchAdapter.OnClickCategoryListener categoryListener;

    public CategoryAdapter() {
    }

    public CategoryAdapter(String[] categoryName, Integer[] categoryIcon) {
        this.categoryName = categoryName;
        this.categoryIcon = categoryIcon;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListitemCategoryBinding binding = ListitemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CategoryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        holder.onBind2(categoryName,categoryIcon,position,categoryListener);
    }


    public void setOnClickCategoryListener(SearchAdapter.OnClickCategoryListener categoryListener) {
        this.categoryListener = categoryListener;
    }

    @Override
    public int getItemCount() {
        return categoryName.length;
    }

    public void addAll(ArrayList<String> nameList, ArrayList<Integer> iconList){
        this.nameList.clear();
        this.nameList.addAll(nameList);
        this.iconList.clear();
        this.iconList.addAll(iconList);
    }
}