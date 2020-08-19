package id.co.mdd.ecommerce.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import id.co.mdd.ecommerce.R;
import id.co.mdd.ecommerce.databinding.ItemProductBinding;
import id.co.mdd.ecommerce.entities.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> products = new ArrayList<>();

    public interface ProductListener{
        void onUpdate(Product product);
        void onDelete(Product product);

    }
    private ProductListener listener;

    public void setListener(ProductListener listener) {
        this.listener = listener;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_product,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
            holder.bindData(products.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemProductBinding binding;

        public ViewHolder(@NonNull ItemProductBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bindData(Product product, ProductListener listener) {
            binding.setProduct(product);

            DecimalFormat rupiah = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols format = new DecimalFormatSymbols();

            format.setCurrencySymbol("Rp. ");
            format.setMonetaryDecimalSeparator(',');
            format.setGroupingSeparator('.');

            rupiah.setDecimalFormatSymbols(format);

            binding.setPrice(rupiah.format(product.getPrice()));




        }
    }
}
