package ru.ianasimonenko.fragmentproject.Profile.Model.GET;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("basket_counter")
    @Expose
    private Integer basketCounter;
    @SerializedName("client")
    @Expose
    private Client client;
    @SerializedName("company")
    @Expose
    private Company company;

    public Status(String status, Integer basketCounter, Client client, Company company) {
        this.status = status;
        this.basketCounter = basketCounter;
        this.client = client;
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBasketCounter() {
        return basketCounter;
    }

    public void setBasketCounter(Integer basketCounter) {
        this.basketCounter = basketCounter;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
