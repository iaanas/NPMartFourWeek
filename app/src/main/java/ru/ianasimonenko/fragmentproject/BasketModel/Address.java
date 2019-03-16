package ru.ianasimonenko.fragmentproject.BasketModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("corp")
    @Expose
    private String corp;

    @SerializedName("flat")
    @Expose
    private String flat;

    @SerializedName("house")
    @Expose
    private String house;

    @SerializedName("street")
    @Expose
    private String street;

    public Address(String city, String corp, String flat, String house, String street) {
        this.city = city;
        this.corp = corp;
        this.flat = flat;
        this.house = house;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getCorp() {
        return corp;
    }

    public String getFlat() {
        return flat;
    }

    public String getHouse() {
        return house;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
