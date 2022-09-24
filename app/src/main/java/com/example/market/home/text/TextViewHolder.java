package com.example.market.home.text;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemTextBinding;

public class TextViewHolder extends RecyclerView.ViewHolder {
    ListitemTextBinding textBinding;
    public TextViewHolder(ListitemTextBinding textBinding) {
        super(textBinding.getRoot());
        this.textBinding  = textBinding;

    }
}
