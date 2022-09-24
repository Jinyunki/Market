package com.example.market.home.product_brand;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.market.databinding.FragmentProductsBinding;
import com.example.market.databinding.ListitemProductItemBinding;
import com.example.market.home.product_brand.products.ProductAdapter;

public class ProductFragment extends Fragment {


    public static final String PRODUCT_POSITION = "PRODUCT_POSITION";
    public static ProductFragment getProductInstance(Bundle bundle) {
        ProductFragment productFragment = new ProductFragment();
        productFragment.setArguments(bundle);
        return productFragment;
    }
    public ProductFragment() {}
    FragmentProductsBinding productBinding;
    ListitemProductItemBinding productItemBinding;
    ProductAdapter adapter;
    int position = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        productBinding = FragmentProductsBinding.inflate(inflater,container,false);
        Bundle bundle = getArguments();
        position = bundle.getInt(PRODUCT_POSITION);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        productBinding.rvProduct.setLayoutManager(gridLayoutManager);
        adapter = new ProductAdapter(productItemBinding,getContext());
        productBinding.rvProduct.setAdapter(adapter);

        return productBinding.getRoot();
    }
}
