package ru.ianasimonenko.fragmentproject.OrdersModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("restaurant_id")
    @Expose
    private Integer restaurantId;
    @SerializedName("client")
    @Expose
    private Client client;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("arriving")
    @Expose
    private Long arriving;
    @SerializedName("price_total")
    @Expose
    private Integer priceTotal;
    @SerializedName("readable_state")
    @Expose
    private String readableState;
    @SerializedName("people_amount")
    @Expose
    private Integer peopleAmount;
    @SerializedName("readable_presence_state")
    @Expose
    private String readablePresenceState;
    @SerializedName("loyalty_points")
    @Expose
    private Integer loyaltyPoints;
    @SerializedName("loyalty_points_price_total")
    @Expose
    private Integer loyaltyPointsPriceTotal;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("is_paid")
    @Expose
    private String isPaid;
    @SerializedName("positions")
    @Expose
    private List<Position> positions = null;
    @SerializedName("restaurant")
    @Expose
    private Restaurant restaurant;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getArriving() {
        return arriving;
    }

    public void setArriving(Long
                                    arriving) {
        this.arriving = arriving;
    }

    public Integer getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getReadableState() {
        return readableState;
    }

    public void setReadableState(String readableState) {
        this.readableState = readableState;
    }

    public Integer getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(Integer peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public String getReadablePresenceState() {
        return readablePresenceState;
    }

    public void setReadablePresenceState(String readablePresenceState) {
        this.readablePresenceState = readablePresenceState;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Integer getLoyaltyPointsPriceTotal() {
        return loyaltyPointsPriceTotal;
    }

    public void setLoyaltyPointsPriceTotal(Integer loyaltyPointsPriceTotal) {
        this.loyaltyPointsPriceTotal = loyaltyPointsPriceTotal;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
