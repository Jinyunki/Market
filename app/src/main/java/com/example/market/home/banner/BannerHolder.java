package com.example.market.home.banner;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.market.databinding.ListitemBannerBinding;

public class BannerHolder extends RecyclerView.ViewHolder {

    public ListitemBannerBinding bannerBinding;

    public BannerHolder(ListitemBannerBinding bannerBinding) {
        super(bannerBinding.getRoot());
        this.bannerBinding = bannerBinding;
    }

    public void onBind(FragmentManager fragmentManager, Lifecycle lifecycle, Integer[] colors) {
        BannerFragAdapter adapter = new BannerFragAdapter(fragmentManager, lifecycle);
        adapter.setColors(colors);

        int pageCount = adapter.getItemCount();
        bannerBinding.vpHomeBanner.setAdapter(adapter);
        bannerBinding.tvBannerIndicator.setText("1/" + pageCount);
        bannerBinding.vpHomeBanner.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                int currentPage = position+1;
                String bannerCount = currentPage + "/" + pageCount;
                bannerBinding.tvBannerIndicator.setText(bannerCount);
            }
        });
    }
}
