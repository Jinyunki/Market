package com.example.market.home.banner;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.market.databinding.FragmentBannerBinding;


public class BannerFragment extends Fragment {

    public static final String BANNER_POSITION = "BANNER_POSITION";
    public static final String BANNER_COLOR = "BANNER_COLOR";

    public static BannerFragment getBannerInstance(Bundle bundle) {
        BannerFragment bannerFragment =  new BannerFragment();
        bannerFragment.setArguments(bundle);
        return bannerFragment;
    }
    public BannerFragment() {}

    FragmentBannerBinding binding;
    int position = 0;
    int color = Color.WHITE;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBannerBinding.inflate(inflater,container,false);
        Bundle bundle = getArguments();
        position = bundle.getInt(BANNER_POSITION);

        color = bundle.getInt(BANNER_COLOR, Color.WHITE);
        binding.parent.setBackgroundColor(color);
        binding.tvIndex.setText(String.valueOf(position));
        return binding.getRoot();
    }
}
