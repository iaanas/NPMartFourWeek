package ru.ianasimonenko.fragmentproject.BasketModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExampleTimes {

    @SerializedName("delivery_times")
    @Expose
    private List<DeliveryTime> deliveryTimes = null;

    public List<DeliveryTime> getDeliveryTimes() {
        return deliveryTimes;
    }

    public void setDeliveryTimes(List<DeliveryTime> deliveryTimes) {
        this.deliveryTimes = deliveryTimes;
    }

}
