package com.example.market.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.market.data.Data;
import com.example.market.data.ImageData;
import com.example.market.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public static HomeFragment getInstance(Bundle bundle) {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    private HomeFragment() {
    }

    Integer[] colors = {};
    private FragmentHomeBinding binding;
    private int position = 0;
    private HomeRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        Bundle bundle = getArguments();
        position = bundle.getInt(Data.HOME_POSITION);

        // api
        loadData();

        adapter = new HomeRecyclerViewAdapter(getChildFragmentManager(), getLifecycle());
        adapter.setColors(this.colors);
        binding.rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvHome.setAdapter(adapter);
        return binding.getRoot();
    }

    private void loadData() {
        this.colors = new Integer[] { Color.RED,Color.BLUE,Color.BLACK,Color.GRAY,Color.GREEN,Color.WHITE,Color.YELLOW,Color.DKGRAY };
    }
}
