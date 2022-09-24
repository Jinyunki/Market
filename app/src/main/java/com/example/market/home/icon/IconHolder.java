package com.example.market.home.icon;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.data.Utils;
import com.example.market.databinding.ListitemIconBinding;
import com.example.market.home.HomeRecyclerViewAdapter;

public class IconHolder extends RecyclerView.ViewHolder {
    ListitemIconBinding binding;
    IconAdapter adapter;
    Context context;

    public IconHolder(ListitemIconBinding binding) {
        super(binding.getRoot());
        this.binding = binding;


    }
    public void onBind (HomeRecyclerViewAdapter.OnClickCategoryListener categoryListener){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2,GridLayoutManager.HORIZONTAL,false);
        binding.rvCategory.setLayoutManager(gridLayoutManager);
        adapter = new IconAdapter();
        adapter.setOnClickCategoryListener(categoryListener);
        binding.rvCategory.setAdapter(adapter);

        binding.rvCategory.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.left = Utils.dpToPx(parent.getContext(), 15);
                outRect.right = Utils.dpToPx(parent.getContext(), 15);
                outRect.top = Utils.dpToPx(parent.getContext(), 10);
                outRect.bottom = Utils.dpToPx(parent.getContext(), 10);
            }
        });
    }

}
