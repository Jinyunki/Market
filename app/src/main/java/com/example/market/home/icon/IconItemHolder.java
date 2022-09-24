package com.example.market.home.icon;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemIconItemBinding;
import com.example.market.home.HomeRecyclerViewAdapter;

public class IconItemHolder extends RecyclerView.ViewHolder {
    ListitemIconItemBinding binding;


    public IconItemHolder(ListitemIconItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(String[] firstTab, Integer[] tabIcons,int position, HomeRecyclerViewAdapter.OnClickCategoryListener categoryListener) {
        binding.tvIcon.setText(firstTab[position]);
        binding.ivIcon.setImageResource(tabIcons[position]);
        binding.llIconItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryListener.onCategory(firstTab, tabIcons, position);
            }
        });
    }

}
