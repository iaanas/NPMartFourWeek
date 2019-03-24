package ru.naparahandroid.fragmentproject.Products.Model24;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CompanyProducts {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("telegram_bot_username")
    @Expose
    private String telegramBotUsername;
    @SerializedName("delivery_min_price")
    @Expose
    private Integer deliveryMinPrice;
    @SerializedName("pass_template_id")
    @Expose
    private String passTemplateId;
    @SerializedName("ymap_center_lat")
    @Expose
    private String ymapCenterLat;
    @SerializedName("ymap_center_lon")
    @Expose
    private String ymapCenterLon;
    @SerializedName("ymap_zoom")
    @Expose
    private Integer ymapZoom;
    @SerializedName("google_play_id")
    @Expose
    private String googlePlayId;
    @SerializedName("app_store_id")
    @Expose
    private Integer appStoreId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("presenceProducts")
    @Expose
    private List<PresenceProducts> presenceProducts = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelegramBotUsername() {
        return telegramBotUsername;
    }

    public void setTelegramBotUsername(String telegramBotUsername) {
        this.telegramBotUsername = telegramBotUsername;
    }

    public Integer getDeliveryMinPrice() {
        return deliveryMinPrice;
    }

    public void setDeliveryMinPrice(Integer deliveryMinPrice) {
        this.deliveryMinPrice = deliveryMinPrice;
    }

    public String getPassTemplateId() {
        return passTemplateId;
    }

    public void setPassTemplateId(String passTemplateId) {
        this.passTemplateId = passTemplateId;
    }

    public String getYmapCenterLat() {
        return ymapCenterLat;
    }

    public void setYmapCenterLat(String ymapCenterLat) {
        this.ymapCenterLat = ymapCenterLat;
    }

    public String getYmapCenterLon() {
        return ymapCenterLon;
    }

    public void setYmapCenterLon(String ymapCenterLon) {
        this.ymapCenterLon = ymapCenterLon;
    }

    public Integer getYmapZoom() {
        return ymapZoom;
    }

    public void setYmapZoom(Integer ymapZoom) {
        this.ymapZoom = ymapZoom;
    }

    public String getGooglePlayId() {
        return googlePlayId;
    }

    public void setGooglePlayId(String googlePlayId) {
        this.googlePlayId = googlePlayId;
    }

    public Integer getAppStoreId() {
        return appStoreId;
    }

    public void setAppStoreId(Integer appStoreId) {
        this.appStoreId = appStoreId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PresenceProducts> getPresenceProducts() {
        return presenceProducts;
    }

    public void setPresenceProducts(List<PresenceProducts> presenceProducts) {
        this.presenceProducts = presenceProducts;
    }

}
