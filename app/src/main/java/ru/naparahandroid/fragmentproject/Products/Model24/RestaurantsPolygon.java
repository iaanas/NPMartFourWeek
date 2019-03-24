package ru.naparahandroid.fragmentproject.Products.Model24;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class RestaurantsPolygon {

    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    @SerializedName("properties")
    @Expose
    private Properties properties;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
