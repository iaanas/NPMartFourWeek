package ru.ianasimonenko.fragmentproject.BasketModel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenBasket {

    @SerializedName("basket_positions")
    @Expose
    private List<BasketPosition> basketPositions = null;
    @SerializedName("loyalty_points_price_total")
    @Expose
    private Integer loyaltyPointsPriceTotal;
    @SerializedName("price_total")
    @Expose
    private Integer priceTotal;
    @SerializedName("calories_total")
    @Expose
    private Integer caloriesTotal;
    @SerializedName("times")
    @Expose
    private Times times;
    @SerializedName("delivery_times")
    @Expose
    private List<DeliveryTime> deliveryTimes = null;
    @SerializedName("restaurants")
    @Expose
    private List<Restaurant> restaurants = null;
    @SerializedName("restaurants_polygons")
    @Expose
    private List<RestaurantsPolygon> restaurantsPolygons = null;
    @SerializedName("last_address")
    @Expose
    private LastAddress lastAddress;
    @SerializedName("possible_times")
    @Expose
    private PossibleTimes possibleTimes;
    @SerializedName("possible_delivery_times")
    @Expose
    private Object possibleDeliveryTimes;
    @SerializedName("payment_types")
    @Expose
    private List<List<String>> paymentTypes = null;
    @SerializedName("basket_counter")
    @Expose
    private Integer basketCounter;
    @SerializedName("client")
    @Expose
    private Client_ client;
    @SerializedName("company")
    @Expose
    private Company company;

    public List<BasketPosition> getBasketPositions() {
        return basketPositions;
    }

    public void setBasketPositions(List<BasketPosition> basketPositions) {
        this.basketPositions = basketPositions;
    }

    public Integer getLoyaltyPointsPriceTotal() {
        return loyaltyPointsPriceTotal;
    }

    public void setLoyaltyPointsPriceTotal(Integer loyaltyPointsPriceTotal) {
        this.loyaltyPointsPriceTotal = loyaltyPointsPriceTotal;
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

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<RestaurantsPolygon> getRestaurantsPolygons() {
        return restaurantsPolygons;
    }

    public void setRestaurantsPolygons(List<RestaurantsPolygon> restaurantsPolygons) {
        this.restaurantsPolygons = restaurantsPolygons;
    }

    public LastAddress getLastAddress() {
        return lastAddress;
    }

    public void setLastAddress(LastAddress lastAddress) {
        this.lastAddress = lastAddress;
    }

    public PossibleTimes getPossibleTimes() {
        return possibleTimes;
    }

    public void setPossibleTimes(PossibleTimes possibleTimes) {
        this.possibleTimes = possibleTimes;
    }

    public Object getPossibleDeliveryTimes() {
        return possibleDeliveryTimes;
    }

    public void setPossibleDeliveryTimes(Object possibleDeliveryTimes) {
        this.possibleDeliveryTimes = possibleDeliveryTimes;
    }

    public List<List<String>> getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(List<List<String>> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public Integer getBasketCounter() {
        return basketCounter;
    }

    public void setBasketCounter(Integer basketCounter) {
        this.basketCounter = basketCounter;
    }

    public Client_ getClient() {
        return client;
    }

    public void setClient(Client_ client) {
        this.client = client;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<DeliveryTime> getDeliveryTimes() {
        return deliveryTimes;
    }

    public void setDeliveryTimes(List<DeliveryTime> deliveryTimes) {
        this.deliveryTimes = deliveryTimes;
    }

    public Times getTimes() {
        return times;
    }

    public void setTimes(Times times) {
        this.times = times;
    }
}
