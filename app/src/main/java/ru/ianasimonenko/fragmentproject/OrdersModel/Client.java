package ru.ianasimonenko.fragmentproject.OrdersModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Client {

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("loyalty_points")
    @Expose
    private Integer loyaltyPoints;
    @SerializedName("notify_about_orders_by_email")
    @Expose
    private Boolean notifyAboutOrdersByEmail;
    @SerializedName("successful_orders")
    @Expose
    private Integer successfulOrders;
    @SerializedName("need_prepay")
    @Expose
    private Boolean needPrepay;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("restaurant_id")
    @Expose
    private Integer restaurantId;
    @SerializedName("birthday")
    @Expose
    private Birthday birthday;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Boolean getNotifyAboutOrdersByEmail() {
        return notifyAboutOrdersByEmail;
    }

    public void setNotifyAboutOrdersByEmail(Boolean notifyAboutOrdersByEmail) {
        this.notifyAboutOrdersByEmail = notifyAboutOrdersByEmail;
    }

    public Integer getSuccessfulOrders() {
        return successfulOrders;
    }

    public void setSuccessfulOrders(Integer successfulOrders) {
        this.successfulOrders = successfulOrders;
    }

    public Boolean getNeedPrepay() {
        return needPrepay;
    }

    public void setNeedPrepay(Boolean needPrepay) {
        this.needPrepay = needPrepay;
    }

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

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

}
