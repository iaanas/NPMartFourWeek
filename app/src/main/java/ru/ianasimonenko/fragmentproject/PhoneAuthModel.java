package ru.ianasimonenko.fragmentproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class PhoneAuthModel {

    @SerializedName("phone")
    @Expose
    private Integer phoneNumber;

    public PhoneAuthModel(Integer phone) {
        this.phoneNumber = phone;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
