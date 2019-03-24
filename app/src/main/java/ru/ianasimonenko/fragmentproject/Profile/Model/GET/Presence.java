package ru.ianasimonenko.fragmentproject.Profile.Model.GET;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Presence {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("name")
    @Expose
    private String name;

    public Presence(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
