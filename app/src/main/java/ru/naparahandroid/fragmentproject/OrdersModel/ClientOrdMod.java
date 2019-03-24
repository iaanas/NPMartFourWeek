package ru.naparahandroid.fragmentproject.OrdersModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientOrdMod {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("need_prepay")
    @Expose
    private Boolean needPrepay;
    @SerializedName("restaurant_id")
    @Expose
    private Integer restaurantId;
    @SerializedName("loyalty_points")
    @Expose
    private Integer loyaltyPoints;
    @SerializedName("successful_orders")
    @Expose
    private Integer successfulOrders;
    @SerializedName("notify_about_orders_by_email")
    @Expose
    private Boolean notifyAboutOrdersByEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getNeedPrepay() {
        return needPrepay;
    }

    public void setNeedPrepay(Boolean needPrepay) {
        this.needPrepay = needPrepay;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Integer getSuccessfulOrders() {
        return successfulOrders;
    }

    public void setSuccessfulOrders(Integer successfulOrders) {
        this.successfulOrders = successfulOrders;
    }

    public Boolean getNotifyAboutOrdersByEmail() {
        return notifyAboutOrdersByEmail;
    }

    public void setNotifyAboutOrdersByEmail(Boolean notifyAboutOrdersByEmail) {
        this.notifyAboutOrdersByEmail = notifyAboutOrdersByEmail;
    }

}
