package ru.ianasimonenko.fragmentproject.OrdersModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenOrders {

    @SerializedName("orders")
    @Expose
    private List<Order> orders = null;
    @SerializedName("last_order_id")
    @Expose
    private Long lastOrderId;
    @SerializedName("basket_counter")
    @Expose
    private Integer basketCounter;
    @SerializedName("client")
    @Expose
    private Client__ client;
    @SerializedName("company")
    @Expose
    private Company company;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getLastOrderId() {
        return lastOrderId;
    }

    public void setLastOrderId(Long lastOrderId) {
        this.lastOrderId = lastOrderId;
    }

    public Integer getBasketCounter() {
        return basketCounter;
    }

    public void setBasketCounter(Integer basketCounter) {
        this.basketCounter = basketCounter;
    }

    public Client__ getClient() {
        return client;
    }

    public void setClient(Client__ client) {
        this.client = client;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
