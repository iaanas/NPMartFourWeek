package ru.naparahandroid.fragmentproject;

import retrofit2.Call;
import retrofit2.http.GET;

interface RestaurantClient {

    @GET("/api/app/restaurants/")
    Call<JSONResponse> getJSON();

}
