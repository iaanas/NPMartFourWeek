package ru.ianasimonenko.fragmentproject.BasketModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class FourteenTime {

    @SerializedName("stamp")
    @Expose
    private String stamp;
    @SerializedName("name")
    @Expose
    private String name;

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

}
