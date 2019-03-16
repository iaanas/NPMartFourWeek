package ru.ianasimonenko.fragmentproject.OrdersModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Position_ {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("images")
    @Expose
    private List<Object> images = null;
    @SerializedName("in_restaurant_only")
    @Expose
    private Boolean inRestaurantOnly;
    @SerializedName("milliliters")
    @Expose
    private Integer milliliters;
    @SerializedName("menu")
    @Expose
    private Menu menu;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("ext_id")
    @Expose
    private String extId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("grams")
    @Expose
    private Integer grams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public Boolean getInRestaurantOnly() {
        return inRestaurantOnly;
    }

    public void setInRestaurantOnly(Boolean inRestaurantOnly) {
        this.inRestaurantOnly = inRestaurantOnly;
    }

    public Integer getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(Integer milliliters) {
        this.milliliters = milliliters;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrams() {
        return grams;
    }

    public void setGrams(Integer grams) {
        this.grams = grams;
    }

}
