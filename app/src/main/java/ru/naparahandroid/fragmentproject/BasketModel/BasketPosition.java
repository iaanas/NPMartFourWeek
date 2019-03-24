package ru.naparahandroid.fragmentproject.BasketModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasketPosition {

    @SerializedName("quantity")
    @Expose
    private Integer quantity;

    @SerializedName("position")
    @Expose
    private Position position;

    @SerializedName("client")
    @Expose
    private ClientBasket clientBasket;

    @SerializedName("id")
    @Expose
    private Integer id;

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
    private Integer caloriesSingleItem;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ClientBasket getClientBasket() {
        return clientBasket;
    }

    public void setClientBasket(ClientBasket clientBasket) {
        this.clientBasket = clientBasket;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCaloriesSingleItem() {
        return caloriesSingleItem;
    }

    public void setCaloriesSingleItem(Integer caloriesSingleItem) {
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
