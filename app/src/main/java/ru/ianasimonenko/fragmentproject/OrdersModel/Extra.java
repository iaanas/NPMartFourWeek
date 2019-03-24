package ru.ianasimonenko.fragmentproject.OrdersModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extra {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("client")
    @Expose
    private ClientOrdMod client;
    @SerializedName("position")
    @Expose
    private PositionOrdModTwo position;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("price_total")
    @Expose
    private Integer priceTotal;
    @SerializedName("calories_total")
    @Expose
    private Integer caloriesTotal;
    @SerializedName("price_subitems")
    @Expose
    private Integer priceSubitems;
    @SerializedName("calories_subitems")
    @Expose
    private Integer caloriesSubitems;
    @SerializedName("price_single_item")
    @Expose
    private Integer priceSingleItem;
    @SerializedName("calories_single_item")
    @Expose
    private Object caloriesSingleItem;
    @SerializedName("loyalty_points_price_total")
    @Expose
    private Integer loyaltyPointsPriceTotal;
    @SerializedName("loyalty_points_price_subitems")
    @Expose
    private Integer loyaltyPointsPriceSubitems;
    @SerializedName("loyalty_points_price_single_item")
    @Expose
    private Object loyaltyPointsPriceSingleItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientOrdMod getClient() {
        return client;
    }

    public void setClient(ClientOrdMod client) {
        this.client = client;
    }

    public PositionOrdModTwo getPosition() {
        return position;
    }

    public void setPosition(PositionOrdModTwo position) {
        this.position = position;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Integer getCaloriesTotal() {
        return caloriesTotal;
    }

    public void setCaloriesTotal(Integer caloriesTotal) {
        this.caloriesTotal = caloriesTotal;
    }

    public Integer getPriceSubitems() {
        return priceSubitems;
    }

    public void setPriceSubitems(Integer priceSubitems) {
        this.priceSubitems = priceSubitems;
    }

    public Integer getCaloriesSubitems() {
        return caloriesSubitems;
    }

    public void setCaloriesSubitems(Integer caloriesSubitems) {
        this.caloriesSubitems = caloriesSubitems;
    }

    public Integer getPriceSingleItem() {
        return priceSingleItem;
    }

    public void setPriceSingleItem(Integer priceSingleItem) {
        this.priceSingleItem = priceSingleItem;
    }

    public Object getCaloriesSingleItem() {
        return caloriesSingleItem;
    }

    public void setCaloriesSingleItem(Object caloriesSingleItem) {
        this.caloriesSingleItem = caloriesSingleItem;
    }

    public Integer getLoyaltyPointsPriceTotal() {
        return loyaltyPointsPriceTotal;
    }

    public void setLoyaltyPointsPriceTotal(Integer loyaltyPointsPriceTotal) {
        this.loyaltyPointsPriceTotal = loyaltyPointsPriceTotal;
    }

    public Integer getLoyaltyPointsPriceSubitems() {
        return loyaltyPointsPriceSubitems;
    }

    public void setLoyaltyPointsPriceSubitems(Integer loyaltyPointsPriceSubitems) {
        this.loyaltyPointsPriceSubitems = loyaltyPointsPriceSubitems;
    }

    public Object getLoyaltyPointsPriceSingleItem() {
        return loyaltyPointsPriceSingleItem;
    }

    public void setLoyaltyPointsPriceSingleItem(Object loyaltyPointsPriceSingleItem) {
        this.loyaltyPointsPriceSingleItem = loyaltyPointsPriceSingleItem;
    }

}
