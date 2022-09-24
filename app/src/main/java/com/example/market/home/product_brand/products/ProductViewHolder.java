package com.example.market.home.product_brand.products;

import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemProductItemBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    ListitemProductItemBinding productItemBinding;

    public ProductViewHolder(ListitemProductItemBinding productItemBinding) {
        super(productItemBinding.getRoot());
        this.productItemBinding = productItemBinding;

    }
}
