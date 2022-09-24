package com.example.market.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.market.data.Data;
import com.example.market.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements HomeRecyclerViewAdapter.OnClickCategoryListener {

    public static HomeFragment getInstance(Bundle bundle) {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }
    private HomeFragment() {}

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
        adapter.setOnClickCategoryListener(HomeFragment.this);
        adapter.setColors(this.colors);

        binding.rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvHome.setAdapter(adapter);
        return binding.getRoot();
    }

    private void loadData() {
        this.colors = new Integer[] { Color.RED,Color.BLUE,Color.BLACK,Color.GRAY,Color.GREEN,Color.WHITE,Color.YELLOW,Color.DKGRAY };
    }

    @Override
    public void onCategory(String[] firstTab, Integer[] tabIcons, int position) {
        Toast.makeText(getContext(), firstTab[position] + "을 터치하셨습니다", Toast.LENGTH_SHORT).show();
    }
}
