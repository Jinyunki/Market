package com.example.market.talk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.market.data.Data;
import com.example.market.databinding.FragmentAddBinding;
import com.example.market.databinding.FragmentTalkBinding;

public class TalkFragment extends Fragment {

    public static TalkFragment getInstance(Bundle bundle) {
        TalkFragment talkFragment = new TalkFragment();
        talkFragment.setArguments(bundle);
        return talkFragment;
    }

    private TalkFragment() {}

    private FragmentTalkBinding binding;
    private int position = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTalkBinding.inflate(inflater, container, false);
        Bundle bundle = getArguments();
        position = bundle.getInt(Data.TALK_POSITION);

        return binding.getRoot();
    }
}
