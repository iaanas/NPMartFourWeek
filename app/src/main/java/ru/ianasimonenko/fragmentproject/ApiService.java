package ru.ianasimonenko.fragmentproject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;
import ru.ianasimonenko.fragmentproject.Model.Example;

public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("/api/app/menus/")
    Call<Example> getMyJSON();

    @GET("/api/app/basket/")
    Call<GenBasket> getMyBasket(@Header("Authorization") String token);

    @POST("/api/app/basket/")
    Call<GenBasket> decReaseButton(@Header("Autorization") String token,
                                   @Field("basket_position_id") Integer basket_pos_id,
                                   @Field("type") String type);



}
