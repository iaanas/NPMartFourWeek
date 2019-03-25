package ru.naparahandroid.fragmentproject.InnerMenu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_wide_in_mobile")
    @Expose
    private Boolean isWideInMobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsWideInMobile() {
        return isWideInMobile;
    }

    public void setIsWideInMobile(Boolean isWideInMobile) {
        this.isWideInMobile = isWideInMobile;
    }

}
