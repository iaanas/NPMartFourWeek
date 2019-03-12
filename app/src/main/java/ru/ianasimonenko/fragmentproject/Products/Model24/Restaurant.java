package ru.ianasimonenko.fragmentproject.Products.Model24;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restaurant {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phones")
    @Expose
    private List<String> phones = null;
    @SerializedName("metros")
    @Expose
    private List<String> metros = null;
    @SerializedName("images")
    @Expose
    private List<Object> images = null;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lon")
    @Expose
    private String lon;
    @SerializedName("delivery_area")
    @Expose
    private List<String> deliveryArea = null;
    @SerializedName("metro_stations")
    @Expose
    private List<Object> metroStations = null;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getMetros() {
        return metros;
    }

    public void setMetros(List<String> metros) {
        this.metros = metros;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public List<String> getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(List<String> deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public List<Object> getMetroStations() {
        return metroStations;
    }

    public void setMetroStations(List<Object> metroStations) {
        this.metroStations = metroStations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
