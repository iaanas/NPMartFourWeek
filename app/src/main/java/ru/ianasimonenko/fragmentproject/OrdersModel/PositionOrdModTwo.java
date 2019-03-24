package ru.ianasimonenko.fragmentproject.OrdersModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PositionOrdModTwo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("menu")
    @Expose
    private MenuOrdModTwo menu;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("ext_id")
    @Expose
    private String extId;
    @SerializedName("images")
    @Expose
    private List<Object> images = null;
    @SerializedName("category")
    @Expose
    private CategoryOrdMod category;
    @SerializedName("milliliters")
    @Expose
    private Integer milliliters;
    @SerializedName("in_restaurant_only")
    @Expose
    private Boolean inRestaurantOnly;
    @SerializedName("grams")
    @Expose
    private Integer grams;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MenuOrdModTwo getMenu() {
        return menu;
    }

    public void setMenu(MenuOrdModTwo menu) {
        this.menu = menu;
    }

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

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public CategoryOrdMod getCategory() {
        return category;
    }

    public void setCategory(CategoryOrdMod category) {
        this.category = category;
    }

    public Integer getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(Integer milliliters) {
        this.milliliters = milliliters;
    }

    public Boolean getInRestaurantOnly() {
        return inRestaurantOnly;
    }

    public void setInRestaurantOnly(Boolean inRestaurantOnly) {
        this.inRestaurantOnly = inRestaurantOnly;
    }

    public Integer getGrams() {
        return grams;
    }

    public void setGrams(Integer grams) {
        this.grams = grams;
    }

}
