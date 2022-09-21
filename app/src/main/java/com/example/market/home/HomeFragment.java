package com.example.market.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.market.data.Data;
import com.example.market.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {


    public static HomeFragment getInstance(Bundle bundle) {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    private HomeFragment() {
    }

    private FragmentHomeBinding binding;
    private int position = 0;
    private HomeRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        Bundle bundle = getArguments();
        position = bundle.getInt(Data.HOME_POSITION);

        adapter = new HomeRecyclerViewAdapter(getChildFragmentManager(), getLifecycle());
        binding.rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvHome.setAdapter(adapter);
        return binding.getRoot();
    }
}
