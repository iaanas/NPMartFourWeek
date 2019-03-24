package ru.naparahandroid.fragmentproject.Products.Model24;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Geometry {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("coordinates")
    @Expose
    private List<List<Object>> coordinates = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<Object>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Object>> coordinates) {
        this.coordinates = coordinates;
    }

}
