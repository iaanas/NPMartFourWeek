package ru.ianasimonenko.fragmentproject.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenProducts {

    @SerializedName("dish")
    @Expose
    private Dish dish;
    @SerializedName("company")
    @Expose
    private Company company;

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
