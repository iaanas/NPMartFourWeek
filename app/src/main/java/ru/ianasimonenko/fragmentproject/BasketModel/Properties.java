package ru.ianasimonenko.fragmentproject.BasketModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("hintContent")
    @Expose
    private String hintContent;

    public String getHintContent() {
        return hintContent;
    }

    public void setHintContent(String hintContent) {
        this.hintContent = hintContent;
    }

}
