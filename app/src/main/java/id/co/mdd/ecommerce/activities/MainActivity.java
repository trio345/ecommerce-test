package id.co.mdd.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.co.mdd.ecommerce.R;
import id.co.mdd.ecommerce.adapters.ProductAdapter;
import id.co.mdd.ecommerce.databinding.ActivityMainBinding;
import id.co.mdd.ecommerce.entities.Product;
import id.co.mdd.ecommerce.viewmodel.ProductViewModel;

public class MainActivity extends AppCompatActivity {
    
    
    public static final String DATA_PRODUCT = "DATA PRODUCT";
    private static final int REQUEST_PERMISSIONS = 40;
    private ActivityMainBinding binding;
    private String[] permissions = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private ProductAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ProductAdapter();

        requestPermissions(permissions, REQUEST_PERMISSIONS);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.rvProduct.setAdapter(adapter);

        ProductViewModel viewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        viewModel.getProducts().observe(this, adapter::setProducts);

        adapter.setListener(new ProductAdapter.ProductListener() {
            @Override
            public void onUpdate(Product product) {

            }

            @Override
            public void onDelete(Product product) {

            }
        });


        binding.btnAddProduct.setOnClickListener(view ->
                startActivity(new Intent(this, ProductActivity.class))
                );

    }
    
    
    
}