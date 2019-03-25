package ru.naparahandroid.fragmentproject.InnerMenu;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Part {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("dishes")
    @Expose
    private List<Dish_> dishes = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Dish_> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish_> dishes) {
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
