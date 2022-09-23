package com.example.market.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemBannerBinding;
import com.example.market.home.banner.BannerFragAdapter;
import com.example.market.home.banner.HomeBannerHolder;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeBannerHolder> {
    ListitemBannerBinding bannerBinding;
    FragmentManager fragmentManager;
    Lifecycle lifecycle;
    Integer[] colors = {};
    private HomeRecyclerViewAdapter() {}

    public HomeRecyclerViewAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.fragmentManager = fragmentManager;
        this.lifecycle = lifecycle;
    }

    @NonNull
    @Override
    public HomeBannerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        bannerBinding = ListitemBannerBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new HomeBannerHolder(bannerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeBannerHolder holder, int position) {
        BannerFragAdapter adapter = new BannerFragAdapter(fragmentManager,lifecycle);
        adapter.setColors(this.colors);
        bannerBinding.vpHomeBanner.setAdapter(adapter);
    }

    public void setColors(Integer[] colors) {
        this.colors = colors;
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
