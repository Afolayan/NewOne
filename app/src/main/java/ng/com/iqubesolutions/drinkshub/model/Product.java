package ng.com.iqubesolutions.drinkshub.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Afolayan Oluwaseyi on 5/25/17.
 */

public class Product {
    @SerializedName("categoryId")
    String categoryId;

    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("price")
    String price;
    @SerializedName("productId")
    String productId;
    @SerializedName("image")
    String imageUrl;
    @SerializedName("products")
    String products;

    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getProducts() {
        return products;
    }
}
