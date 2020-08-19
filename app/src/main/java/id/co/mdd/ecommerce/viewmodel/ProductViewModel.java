package id.co.mdd.ecommerce.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

import id.co.mdd.ecommerce.entities.Product;
import id.co.mdd.ecommerce.repositories.ProductRepository;

public class ProductViewModel extends AndroidViewModel {
    private MutableLiveData<String> photo = new MutableLiveData<>("");
    private MutableLiveData<String> query = new MutableLiveData<>("%");
    private MutableLiveData<Product> product = new MutableLiveData<>();

    private LiveData<List<Product>> products;
    private ProductRepository productRepository;


    public ProductViewModel(@NonNull Application application) {
        super(application);

        productRepository = new ProductRepository(application);

        products = Transformations.switchMap(query, s -> productRepository.filteredProducts(s));

    }


    public void setPhoto(MutableLiveData<String> photo) {
        this.photo = photo;
    }

    public void setProduct(MutableLiveData<Product> product) {
        this.product = product;
    }

    public LiveData<List<Product>> getProducts() {
        return products;
    }

    public MutableLiveData<Product> getProduct() {
        return product;
    }
}
