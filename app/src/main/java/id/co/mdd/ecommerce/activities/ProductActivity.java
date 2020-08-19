package id.co.mdd.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.io.File;

import id.co.mdd.ecommerce.R;
import id.co.mdd.ecommerce.databinding.ActivityProductBinding;
import id.co.mdd.ecommerce.viewmodel.ProductViewModel;

public class ProductActivity extends AppCompatActivity {

    private ActivityProductBinding binding;
    private File file;
    private ProductViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        


    }
}