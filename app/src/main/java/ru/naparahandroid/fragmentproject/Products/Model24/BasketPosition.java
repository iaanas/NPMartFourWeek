package ru.naparahandroid.fragmentproject.Products.Model24;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class BasketPosition {

    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("positionProducts")
    @Expose
    private PositionProducts positionProducts;
    @SerializedName("client")
    @Expose
    private ClientProducts clientProducts;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("parts")
    @Expose
    private List<Object> parts = null;
    @SerializedName("toppings")
    @Expose
    private List<Object> toppings = null;
    @SerializedName("price_single_item")
    @Expose
    private Integer priceSingleItem;
    @SerializedName("price_subitems")
    @Expose
    private Integer priceSubitems;
    @SerializedName("price_total")
    @Expose
    private Integer priceTotal;
    @SerializedName("loyalty_points_price_single_item")
    @Expose
    private Object loyaltyPointsPriceSingleItem;
    @SerializedName("loyalty_points_price_subitems")
    @Expose
    private Integer loyaltyPointsPriceSubitems;
    @SerializedName("loyalty_points_price_total")
    @Expose
    private Integer loyaltyPointsPriceTotal;
    @SerializedName("calories_single_item")
    @Expose
    private Object caloriesSingleItem;
    @SerializedName("calories_subitems")
    @Expose
    private Integer caloriesSubitems;
    @SerializedName("calories_total")
    @Expose
    private Integer caloriesTotal;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PositionProducts getPositionProducts() {
        return positionProducts;
    }

    public void setPositionProducts(PositionProducts positionProducts) {
        this.positionProducts = positionProducts;
    }

    public ClientProducts getClientProducts() {
        return clientProducts;
    }

    public void setClientProducts(ClientProducts clientProducts) {
        this.clientProducts = clientProducts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Object> getParts() {
        return parts;
    }

    public void setParts(List<Object> parts) {
        this.parts = parts;
    }

    public List<Object> getToppings() {
        return toppings;
    }

    public void setToppings(List<Object> toppings) {
        this.toppings = toppings;
    }

    public Integer getPriceSingleItem() {
        return priceSingleItem;
    }

    public void setPriceSingleItem(Integer priceSingleItem) {
        this.priceSingleItem = priceSingleItem;
    }

    public Integer getPriceSubitems() {
        return priceSubitems;
    }

    public void setPriceSubitems(Integer priceSubitems) {
        this.priceSubitems = priceSubitems;
    }

    public Integer getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Object getLoyaltyPointsPriceSingleItem() {
        return loyaltyPointsPriceSingleItem;
    }

    public void setLoyaltyPointsPriceSingleItem(Object loyaltyPointsPriceSingleItem) {
        this.loyaltyPointsPriceSingleItem = loyaltyPointsPriceSingleItem;
    }

    public Integer getLoyaltyPointsPriceSubitems() {
        return loyaltyPointsPriceSubitems;
    }

    public void setLoyaltyPointsPriceSubitems(Integer loyaltyPointsPriceSubitems) {
        this.loyaltyPointsPriceSubitems = loyaltyPointsPriceSubitems;
    }

    public Integer getLoyaltyPointsPriceTotal() {
        return loyaltyPointsPriceTotal;
    }

    public void setLoyaltyPointsPriceTotal(Integer loyaltyPointsPriceTotal) {
        this.loyaltyPointsPriceTotal = loyaltyPointsPriceTotal;
    }

    public Object getCaloriesSingleItem() {
        return caloriesSingleItem;
    }

    public void setCaloriesSingleItem(Object caloriesSingleItem) {
        this.caloriesSingleItem = caloriesSingleItem;
    }

    public Integer getCaloriesSubitems() {
        return caloriesSubitems;
    }

    public void setCaloriesSubitems(Integer caloriesSubitems) {
        this.caloriesSubitems = caloriesSubitems;
    }

    public Integer getCaloriesTotal() {
        return caloriesTotal;
    }

    public void setCaloriesTotal(Integer caloriesTotal) {
        this.caloriesTotal = caloriesTotal;
    }

}