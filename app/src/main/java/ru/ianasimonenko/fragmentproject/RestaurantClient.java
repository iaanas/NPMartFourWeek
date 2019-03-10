package ru.ianasimonenko.fragmentproject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurantClient {

    @GET("/api/app/restaurants/")
    Call<JSONResponse> getJSON();

}
