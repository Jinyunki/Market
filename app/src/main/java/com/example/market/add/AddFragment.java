package com.example.market.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.market.data.Data;
import com.example.market.databinding.FragmentAddBinding;

public class AddFragment extends Fragment {

    public static AddFragment getInstance(Bundle bundle) {
        AddFragment addFragment = new AddFragment();
        addFragment.setArguments(bundle);
        return addFragment;
    }

    private AddFragment() {}

    private FragmentAddBinding binding;
    private int position = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        Bundle bundle = getArguments();
        position = bundle.getInt(Data.ADD_POSITION);

        binding.tvLocation.setText("서울시 관악구");
        return binding.getRoot();
    }
}
