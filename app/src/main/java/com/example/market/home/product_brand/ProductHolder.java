package com.example.market.home.product_brand;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market.databinding.ListitemProductBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProductHolder extends RecyclerView.ViewHolder {

    private ListitemProductBinding productBinding;

    public ProductHolder(ListitemProductBinding productBinding) {
        super(productBinding.getRoot());
        this.productBinding = productBinding;
    }

    public void onBind(FragmentManager fragmentManager, Lifecycle lifecycle,String[] tabNames){
        ProductFragAdapter adapter = new ProductFragAdapter(fragmentManager,lifecycle);
        productBinding.vpHomeProduct.setAdapter(adapter);
        new TabLayoutMediator(productBinding.tabLayoutProduct, productBinding.vpHomeProduct, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabNames[position]);
            }
        }).attach();
    }
}
