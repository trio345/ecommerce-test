package id.co.mdd.ecommerce.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import id.co.mdd.ecommerce.entities.Product;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM products ORDER BY id DESC")
    public LiveData<List<Product>> getProducts();

    @Query("SELECT * FROM products WHERE name LIKE :query ORDER BY id DESC")
    public LiveData<List<Product>> getFilteredProducts(String query);


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertProduct(Product product);

    @Update
    public void updateProduct(Product product);

    @Delete
    public void deleteProduct(Product product);


}
