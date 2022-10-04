package com.example.market;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.market.add.AddFragment;
import com.example.market.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private Integer[] tabIcons = { R.drawable.ic_home_24, R.drawable.ic_search_24, R.drawable.ic_add_24,R.drawable.ic_talk_24,R.drawable.ic_my_24 };
    private String[] tabNames = {"홈", "검색", "등록", "번개톡", "My"};

    private ActivityMainBinding binding;
    private MainFragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        adapter = new MainFragAdapter(getSupportFragmentManager(), getLifecycle());
        binding.vpMain.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        new TabLayoutMediator(binding.tabLayout, binding.vpMain, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabNames[position]);
                tab.setIcon(tabIcons[position]);
            }
        }).attach();
    }
}