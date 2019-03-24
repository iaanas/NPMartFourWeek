package ru.naparahandroid.fragmentproject.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenProducts {

    @SerializedName("dish")
    @Expose
    private Dish dish;
    @SerializedName("companyProducts")
    @Expose
    private CompanyProducts companyProducts;

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public CompanyProducts getCompanyProducts() {
        return companyProducts;
    }

    public void setCompanyProducts(CompanyProducts companyProducts) {
        this.companyProducts = companyProducts;
    }

}
