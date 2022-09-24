package com.example.market.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.data.Data;
import com.example.market.databinding.ListitemBannerBinding;
import com.example.market.databinding.ListitemIconBinding;
import com.example.market.databinding.ListitemProductBinding;
import com.example.market.databinding.ListitemTextBinding;
import com.example.market.home.banner.BannerHolder;
import com.example.market.home.icon.IconHolder;
import com.example.market.home.product_brand.ProductHolder;
import com.example.market.home.text.TextViewHolder;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnClickCategoryListener {
        void onCategory(String[] firstTab, Integer[] tabIcons,int position);
    }

    OnClickCategoryListener categoryListener;
    FragmentManager fragmentManager;
    Lifecycle lifecycle;
    Integer[] colors = {};


    private final int TYPE_HEADER = 0;
    private final int TYPE_ITEM = 1;
    private final int TYPE_FOOTER = 2;

    private String[] tabNames = {"추천상품", "브랜드"};

    private HomeRecyclerViewAdapter() {
    }

    public HomeRecyclerViewAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.fragmentManager = fragmentManager;
        this.lifecycle = lifecycle;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Data.HOME_BANNER) {
            ListitemBannerBinding bannerBinding = ListitemBannerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new BannerHolder(bannerBinding);
        } else if (viewType == Data.HOME_ICON) {
            ListitemIconBinding iconBinding = ListitemIconBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new IconHolder(iconBinding);
        } else if (viewType == Data.HOME_TEXT) {
            ListitemTextBinding textBinding = ListitemTextBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new TextViewHolder(textBinding);
        } else {
            ListitemProductBinding productBinding = ListitemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ProductHolder(productBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == Data.HOME_BANNER) {
            BannerHolder bannerHolder = (BannerHolder) holder;
            bannerHolder.onBind(fragmentManager, lifecycle, colors);
        } else if (viewType == Data.HOME_ICON){
            IconHolder iconHolder = (IconHolder) holder;
            iconHolder.onBind(categoryListener);
        } else if (viewType == Data.HOME_PRODUCT) {
            ProductHolder productHolder = (ProductHolder) holder;
            productHolder.onBind(fragmentManager,lifecycle,tabNames);
        }
    }

    public void setColors(Integer[] colors) {
        this.colors = colors;
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
            return Data.HOME_BANNER;
        } else if (position == 1) {
            return Data.HOME_ICON;
        } else if (position == 2) {
            return Data.HOME_TEXT;
        } else if (position == 3) {
            return Data.HOME_PRODUCT;
        } else {
            return -1;
        }
    }
}
