package ru.ianasimonenko.fragmentproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.ianasimonenko.fragmentproject.BasketModel.Company;

public class AccessUser {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("need_user_data")
    @Expose
    private Boolean needUserData;
    @SerializedName("company")
    @Expose
    private Company company;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Boolean getNeedUserData() {
        return needUserData;
    }

    public void setNeedUserData(Boolean needUserData) {
        this.needUserData = needUserData;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
