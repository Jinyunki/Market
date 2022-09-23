package com.example.market.home.banner;

import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemBannerBinding;

public class HomeBannerHolder extends RecyclerView.ViewHolder {

    private ListitemBannerBinding bannerBinding;

    public HomeBannerHolder(ListitemBannerBinding bannerBinding) {
        super(bannerBinding.getRoot());
        this.bannerBinding = bannerBinding;
    }
}
