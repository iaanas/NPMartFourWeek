package ru.ianasimonenko.fragmentproject.BasketModel;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryTime {

    @SerializedName("stamp")
    @Expose
    private String stamp;
    @SerializedName("name")
    @Expose
    private String name;

    public DeliveryTime(String name, String stamp) {
        this.stamp = stamp;
        this.name = name;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return ""+this.name;
    }
}
