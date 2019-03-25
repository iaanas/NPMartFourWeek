package ru.naparahandroid.fragmentproject.InnerMenu;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dish_ {

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
    @SerializedName("pos_type")
    @Expose
    private String posType;
    @SerializedName("in_restaurant_only")
    @Expose
    private Boolean inRestaurantOnly;
    @SerializedName("milliliters")
    @Expose
    private Integer milliliters;
    @SerializedName("calories")
    @Expose
    private Integer calories;
    @SerializedName("menu")
    @Expose
    private Menu___ menu;
    @SerializedName("category")
    @Expose
    private Category__ category;
    @SerializedName("ext_id")
    @Expose
    private String extId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("iiko_id")
    @Expose
    private Object iikoId;
    @SerializedName("tillypad_name")
    @Expose
    private Object tillypadName;
    @SerializedName("iiko_name")
    @Expose
    private Object iikoName;

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

    public Integer getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(Integer milliliters) {
        this.milliliters = milliliters;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Menu___ getMenu() {
        return menu;
    }

    public void setMenu(Menu___ menu) {
        this.menu = menu;
    }

    public Category__ getCategory() {
        return category;
    }

    public void setCategory(Category__ category) {
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

    public Object getIikoId() {
        return iikoId;
    }

    public void setIikoId(Object iikoId) {
        this.iikoId = iikoId;
    }

    public Object getTillypadName() {
        return tillypadName;
    }

    public void setTillypadName(Object tillypadName) {
        this.tillypadName = tillypadName;
    }

    public Object getIikoName() {
        return iikoName;
    }

    public void setIikoName(Object iikoName) {
        this.iikoName = iikoName;
    }

}
