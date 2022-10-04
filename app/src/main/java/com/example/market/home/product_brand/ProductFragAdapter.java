package com.example.market.home.product_brand;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ProductFragAdapter extends FragmentStateAdapter {

    public ProductFragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(ProductFragment.PRODUCT_POSITION,position);
        return ProductFragment.getProductInstance(bundle);

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
