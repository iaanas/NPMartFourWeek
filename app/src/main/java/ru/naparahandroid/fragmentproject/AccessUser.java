package ru.naparahandroid.fragmentproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.naparahandroid.fragmentproject.BasketModel.CompanyBasket;

public class AccessUser {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("need_user_data")
    @Expose
    private Boolean needUserData;
    @SerializedName("companyBasket")
    @Expose
    private CompanyBasket companyBasket;

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

    public CompanyBasket getCompanyBasket() {
        return companyBasket;
    }

    public void setCompanyBasket(CompanyBasket companyBasket) {
        this.companyBasket = companyBasket;
    }

}
