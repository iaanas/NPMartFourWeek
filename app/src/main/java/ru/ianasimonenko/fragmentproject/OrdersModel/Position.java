package ru.ianasimonenko.fragmentproject.OrdersModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Position {

    @SerializedName("position")
    @Expose
    private PositionOrdMod position;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("price_single_item")
    @Expose
    private Integer priceSingleItem;
    @SerializedName("price_subitems")
    @Expose
    private Integer priceSubitems;
    @SerializedName("price_total")
    @Expose
    private Integer priceTotal;
    @SerializedName("extra")
    @Expose
    private Extra extra;
    @SerializedName("id")
    @Expose
    private Integer id;

    public PositionOrdMod getPosition() {
        return position;
    }

    public void setPosition(PositionOrdMod position) {
        this.position = position;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
