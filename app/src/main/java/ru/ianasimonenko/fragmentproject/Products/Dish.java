package ru.ianasimonenko.fragmentproject.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Dish {

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
    private List<String> images = null;
    @SerializedName("pos_type")
    @Expose
    private String posType;
    @SerializedName("in_restaurant_only")
    @Expose
    private Boolean inRestaurantOnly;
    @SerializedName("grams")
    @Expose
    private Integer grams;
    @SerializedName("calories")
    @Expose
    private Integer calories;
    @SerializedName("description")
    @Expose
    private String description;
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
    @SerializedName("parts")
    @Expose
    private List<Object> parts = null;
    @SerializedName("toppings")
    @Expose
    private List<Object> toppings = null;

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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getPosType() {
        return posType;
    }

    public void setPosType(String posType) {
        this.posType = posType;
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

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Object> getParts() {
        return parts;
    }

    public void setParts(List<Object> parts) {
        this.parts = parts;
    }

    public List<Object> getToppings() {
        return toppings;
    }

    public void setToppings(List<Object> toppings) {
        this.toppings = toppings;
    }

}
