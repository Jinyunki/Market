package com.example.market.home.icon;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.R;
import com.example.market.databinding.ListitemIconItemBinding;
import com.example.market.home.HomeRecyclerViewAdapter;

public class IconAdapter extends RecyclerView.Adapter<IconItemHolder> {
    ListitemIconItemBinding binding;
    HomeRecyclerViewAdapter.OnClickCategoryListener categoryListener;

    private String[] firstTab = {"찜", "조던", "최근본상품", "스니커즈", "내피드", "캠핑", "내폰시세", "자전거", "우리동네", "스타굿즈", "친구초대", "오토바이/스쿠터", "전체메뉴", "시계"};
    private Integer[] tabIcons = {R.drawable.ic_heart_24, R.drawable.ic_jordan_24, R.drawable.ic_watch_24, R.drawable.ic_sneakers_24,
            R.drawable.ic_thumb_24, R.drawable.ic_camping_24, R.drawable.ic_phone_24, R.drawable.ic_bike_24,
            R.drawable.ic_place_24, R.drawable.ic_star_24, R.drawable.ic_invite_24, R.drawable.ic_motor_24,
            R.drawable.ic_menu_24, R.drawable.ic_hand_watch_24};

    @NonNull
    @Override
    public IconItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ListitemIconItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new IconItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull IconItemHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(firstTab,tabIcons,position, categoryListener);
    }

    public void setOnClickCategoryListener(HomeRecyclerViewAdapter.OnClickCategoryListener categoryListener) {
        this.categoryListener = categoryListener;
    }

    @Override
    public int getItemCount() {
        return firstTab.length;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
