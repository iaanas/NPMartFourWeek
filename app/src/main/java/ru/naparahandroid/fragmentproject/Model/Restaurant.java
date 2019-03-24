package ru.naparahandroid.fragmentproject.Model;

import android.media.Image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restaurant {

    @SerializedName("opening_hours")
    @Expose
    private String openingHours;

    @SerializedName("restaurant_name")
    @Expose
    private String restaurantName;

    @SerializedName("restaurant_id")
    @Expose
    private Integer restaurantId;

    @SerializedName("lat")
    @Expose
    private String lat;

    @SerializedName("long")
    @Expose
    private String _long;

    @SerializedName("images")
    @Expose
    private List<Image> images = null;

    @SerializedName("phones")
    @Expose
    private List<String> phones = null;

    @SerializedName("address")
    @Expose
    private String address;

//    @SerializedName("menus")
//    @Expose
//    private List<MenuProducts> menus = null;

    @SerializedName("metros")
    @Expose
    private List<String> metros = null;

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public List<MenuProducts> getMenus() {
//        return menus;
//    }
//
//    public void setMenus(List<MenuProducts> menus) {
//        this.menus = menus;
//    }

    public List<String> getMetros() {
        return metros;
    }

    public void setMetros(List<String> metros) {
        this.metros = metros;
    }

}
