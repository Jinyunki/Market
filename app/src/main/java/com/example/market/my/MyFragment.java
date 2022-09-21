package com.example.market.my;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.market.data.Data;
import com.example.market.databinding.FragmentMyBinding;
import com.example.market.databinding.FragmentTalkBinding;

public class MyFragment extends Fragment {

    public static MyFragment getInstance(Bundle bundle) {
        MyFragment myFragment = new MyFragment();
        myFragment.setArguments(bundle);
        return myFragment;
    }

    private MyFragment() {}

    private FragmentMyBinding binding;
    private int position = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMyBinding.inflate(inflater, container, false);
        Bundle bundle = getArguments();
        position = bundle.getInt(Data.MY_POSITION);

        return binding.getRoot();
    }
}
