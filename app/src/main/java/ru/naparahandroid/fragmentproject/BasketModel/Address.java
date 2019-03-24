package ru.naparahandroid.fragmentproject.BasketModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("house")
    @Expose
    private String house;
    @SerializedName("corp")
    @Expose
    private String corp;
    @SerializedName("flat")
    @Expose
    private String flat;

    public Address(String city, String street, String house, String corp, String flat) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.corp = corp;
        this.flat = flat;
    }

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

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

}
