package id.co.mdd.ecommerce.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String photo, name, description;
    private long quantity, price;

    public Product(long id, String photo, String name, String description, long quantity, long price) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    protected Product(Parcel in) {
        id = in.readLong();
        photo = in.readString();
        name = in.readString();
        description = in.readString();
        quantity = in.readLong();
        price = in.readLong();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(photo);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeLong(quantity);
        parcel.writeLong(price);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @BindingAdapter("file")
    public static void setImage(ImageView view, String path){

    }


}
