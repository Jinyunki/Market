package com.example.market.search.category;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemCategoryBinding;
import com.example.market.search.SearchAdapter;

public class CategoryHolder extends RecyclerView.ViewHolder {
    ListitemCategoryBinding binding;

    public CategoryHolder(ListitemCategoryBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public void onBind(String categoryName, Integer categoryIcon){
        binding.tvCategory.setText(categoryName);
        binding.ivCategory.setImageResource(categoryIcon);
    }

    public void onBind2(String[] categoryName, Integer[] categoryIcon, int position, SearchAdapter.OnClickCategoryListener categoryListener){
        binding.tvCategory.setText(categoryName[position]);
        binding.ivCategory.setImageResource(categoryIcon[position]);
        binding.llSearchCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryListener.onCategory(categoryName, categoryIcon, position);
            }
        });
    }
}