package com.example.market.home.banner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class BannerFragAdapter extends FragmentStateAdapter {
    Integer[] colors = {};

    public BannerFragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(BannerFragment.BANNER_POSITION, position);
        bundle.putInt(BannerFragment.BANNER_COLOR, colors[position]);

        return BannerFragment.getBannerInstance(bundle);
    }

    public void setColors(Integer[] colors) {
        this.colors = colors;
    }

    @Override
    public int getItemCount() {
        return colors.length;
    }
}
