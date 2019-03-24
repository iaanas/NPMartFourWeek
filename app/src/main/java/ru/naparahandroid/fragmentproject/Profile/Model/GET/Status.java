package ru.naparahandroid.fragmentproject.Profile.Model.GET;

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
    private ClientProfile clientProfile;
    @SerializedName("companyProfile")
    @Expose
    private CompanyProfile companyProfile;

    public Status(String status, Integer basketCounter, ClientProfile clientProfile, CompanyProfile companyProfile) {
        this.status = status;
        this.basketCounter = basketCounter;
        this.clientProfile = clientProfile;
        this.companyProfile = companyProfile;
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

    public ClientProfile getClientProfile() {
        return clientProfile;
    }

    public void setClientProfile(ClientProfile clientProfile) {
        this.clientProfile = clientProfile;
    }

    public CompanyProfile getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(CompanyProfile companyProfile) {
        this.companyProfile = companyProfile;
    }

}
