package ru.naparahandroid.fragmentproject.Products.Interface;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.naparahandroid.fragmentproject.Products.GenProducts;
import ru.naparahandroid.fragmentproject.Products.Model24.Prod24Gen;

public interface ProductsClient {

    @GET("/api/app/dish/97/")
    Call<GenProducts> get24JSON();

    @FormUrlEncoded
    @POST("/api/app/basket/")
    Call<Prod24Gen> prodToBusket(@Header("Authorization") String token,
                                 @Field("adds") String[] adds,
                                 @Field("position_id") Integer position_id,
                                 @Field("toppings") String top,
                                 @Field("type") String add);
}
