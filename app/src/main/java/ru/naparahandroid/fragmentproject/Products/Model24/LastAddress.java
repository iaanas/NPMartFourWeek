package ru.naparahandroid.fragmentproject.Products.Model24;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastAddress {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("house")
    @Expose
    private Object house;
    @SerializedName("corp")
    @Expose
    private Object corp;
    @SerializedName("flat")
    @Expose
    private Object flat;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Object getHouse() {
        return house;
    }

    public void setHouse(Object house) {
        this.house = house;
    }

    public Object getCorp() {
        return corp;
    }

    public void setCorp(Object corp) {
        this.corp = corp;
    }

    public Object getFlat() {
        return flat;
    }

    public void setFlat(Object flat) {
        this.flat = flat;
    }

}
