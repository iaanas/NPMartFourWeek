package ru.ianasimonenko.fragmentproject.Profile.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class EditProfile {

    @SerializedName("birthday")
    @Expose
    private Birthday birthday;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("notify_about_orders_by_email")
    @Expose
    private String notifyAboutOrdersByEmail;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("phone")
    @Expose
    private String phone;

    public EditProfile(Birthday birthday, String email, String firstName, String lastName, String notifyAboutOrdersByEmail, String type, String phone) {
        this.birthday = birthday;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.notifyAboutOrdersByEmail = notifyAboutOrdersByEmail;
        this.type = type;
        this.phone = phone;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNotifyAboutOrdersByEmail() {
        return notifyAboutOrdersByEmail;
    }

    public String getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNotifyAboutOrdersByEmail(String notifyAboutOrdersByEmail) {
        this.notifyAboutOrdersByEmail = notifyAboutOrdersByEmail;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
