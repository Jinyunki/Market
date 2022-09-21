package com.example.market;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainFragAdapter extends FragmentStateAdapter {

    public MainFragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(HomeFragment.EXTRA_POSITION,(position+1));
        return HomeFragment.getInstance(bundle);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

