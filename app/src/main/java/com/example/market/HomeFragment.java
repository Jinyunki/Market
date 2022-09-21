package com.example.market;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.market.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    // 번들에 사용될 key 값
    public static final String EXTRA_POSITION = "EXTRA_POSITION";

    public static HomeFragment getInstance(Bundle bundle){
        HomeFragment homeFragment =  new HomeFragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }
    private HomeFragment() {}

    FragmentHomeBinding binding;
    int position = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        Bundle bundle = getArguments();
        position = bundle.getInt(EXTRA_POSITION);

        binding.tv.setText(String.valueOf(position));
        return binding.getRoot();
    }
}
