package ru.naparahandroid.fragmentproject.InnerMenu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category__ {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("menu")
    @Expose
    private Menu____ menu;
    @SerializedName("id")
    @Expose
    private Integer id;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Menu____ getMenu() {
        return menu;
    }

    public void setMenu(Menu____ menu) {
        this.menu = menu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
