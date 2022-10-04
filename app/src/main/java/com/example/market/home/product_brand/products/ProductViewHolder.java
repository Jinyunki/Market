package com.example.market.home.product_brand.products;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.market.databinding.ListitemProductItemBinding;
import com.example.market.room.Product;

import java.util.ArrayList;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    ListitemProductItemBinding productItemBinding;

    public ProductViewHolder(ListitemProductItemBinding productItemBinding) {
        super(productItemBinding.getRoot());
        this.productItemBinding = productItemBinding;
    }

    public void onBind(Context context, int position, ArrayList<Product> productList){
        String imgUri = "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/e24cc9da-a136-4262-987d-ab1a435cade1/air-jordan-1-retro-high-og-shoes-1QP6Gw.png";
        Glide.with(context).load(imgUri).into(productItemBinding.ivProductItem);

        Product product = productList.get(position);
        productItemBinding.tvTitle.setText(product.productName);
        int price = product.getPrice();
        String priceStr = String.valueOf(price);

        productItemBinding.tvPrice.setText(priceStr);
    }
}
