package com.example.market.home.product_brand.products;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.market.databinding.ListitemProductItemBinding;
import com.example.market.room.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    ListitemProductItemBinding productItemBinding;
    Context context;
    ArrayList<Product> productList = new ArrayList<>();

    public ProductAdapter(ListitemProductItemBinding productItemBinding, Context context) {
        this.productItemBinding = productItemBinding;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        productItemBinding = ListitemProductItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ProductViewHolder(productItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        String imgUri = "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/e24cc9da-a136-4262-987d-ab1a435cade1/air-jordan-1-retro-high-og-shoes-1QP6Gw.png";
        Glide.with(context).load(imgUri).into(productItemBinding.ivProductItem);

        Product product = productList.get(position);
        productItemBinding.tvTitle.setText(product.productName);
    }

    public void addAll(List<Product> productList){
        this.productList.clear();
        this.productList.addAll(productList);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
