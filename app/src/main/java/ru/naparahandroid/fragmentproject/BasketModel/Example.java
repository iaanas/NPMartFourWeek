package ru.naparahandroid.fragmentproject.BasketModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("arriving")
    @Expose
    private String arriving;
    @SerializedName("cash_change")
    @Expose
    private Object cashChange;
    @SerializedName("clientside_id")
    @Expose
    private String clientsideId;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("online_order")
    @Expose
    private String onlineOrder;
    @SerializedName("payment_type")
    @Expose
    private String paymentType;
    @SerializedName("people_amount")
    @Expose
    private String peopleAmount;
    @SerializedName("presence")
    @Expose
    private String presence;
    @SerializedName("remember_restaurant")
    @Expose
    private Boolean rememberRestaurant;
    @SerializedName("restaurant_id")
    @Expose
    private Integer restaurantId;
    @SerializedName("should_not_call")
    @Expose
    private String shouldNotCall;

    public Example(Address address, String arriving, Object cashChange, String clientsideId, String comment, String onlineOrder, String paymentType, String peopleAmount, String presence, Boolean rememberRestaurant, Integer restaurantId, String shouldNotCall) {
        this.address = address;
        this.arriving = arriving;
        this.cashChange = cashChange;
        this.clientsideId = clientsideId;
        this.comment = comment;
        this.onlineOrder = onlineOrder;
        this.paymentType = paymentType;
        this.peopleAmount = peopleAmount;
        this.presence = presence;
        this.rememberRestaurant = rememberRestaurant;
        this.restaurantId = restaurantId;
        this.shouldNotCall = shouldNotCall;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getArriving() {
        return arriving;
    }

    public void setArriving(String arriving) {
        this.arriving = arriving;
    }

    public Object getCashChange() {
        return cashChange;
    }

    public void setCashChange(Object cashChange) {
        this.cashChange = cashChange;
    }

    public String getClientsideId() {
        return clientsideId;
    }

    public void setClientsideId(String clientsideId) {
        this.clientsideId = clientsideId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOnlineOrder() {
        return onlineOrder;
    }

    public void setOnlineOrder(String onlineOrder) {
        this.onlineOrder = onlineOrder;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(String peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public Boolean getRememberRestaurant() {
        return rememberRestaurant;
    }

    public void setRememberRestaurant(Boolean rememberRestaurant) {
        this.rememberRestaurant = rememberRestaurant;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getShouldNotCall() {
        return shouldNotCall;
    }

    public void setShouldNotCall(String shouldNotCall) {
        this.shouldNotCall = shouldNotCall;
    }

}
