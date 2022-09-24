package com.example.market.home.banner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.market.databinding.ActivityBannerIntentBinding;

public class BannerIntent extends AppCompatActivity {
    ActivityBannerIntentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBannerIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvBannerItem.setText("position");
    }
}