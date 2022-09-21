package com.example.market;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.market.add.AddFragment;
import com.example.market.data.Data;
import com.example.market.home.HomeFragment;
import com.example.market.my.MyFragment;
import com.example.market.search.SearchFragment;
import com.example.market.talk.TalkFragment;

public class MainFragAdapter extends FragmentStateAdapter {

    public MainFragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        if (position == 0) {
            bundle.putInt(Data.HOME_POSITION, position);
            return HomeFragment.getInstance(bundle);
        } else if (position == 1) {
            bundle.putInt(Data.SEARCH_POSITION, position);
            return SearchFragment.getInstance(bundle);
        } else if (position == 2) {
            bundle.putInt(Data.ADD_POSITION, position);
            return AddFragment.getInstance(bundle);
        } else if (position == 3) {
            bundle.putInt(Data.TALK_POSITION, position);
            return TalkFragment.getInstance(bundle);
        } else {
            bundle.putInt(Data.MY_POSITION, position);
            return MyFragment.getInstance(bundle);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

