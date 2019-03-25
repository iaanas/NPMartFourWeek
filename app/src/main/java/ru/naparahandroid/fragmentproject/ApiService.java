package ru.naparahandroid.fragmentproject;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.naparahandroid.fragmentproject.BasketModel.ExampleTimes;
import ru.naparahandroid.fragmentproject.BasketModel.GenBasket;
import ru.naparahandroid.fragmentproject.Model.Example;
import ru.naparahandroid.fragmentproject.OrdersModel.GenOrders;

public interface ApiService {


    @GET("/api/app/menus2/")
    Call<Example> getMyJSON();

    @GET("/api/app/menus2/{id}")
    Call<ru.naparahandroid.fragmentproject.InnerMenu.Example> getMyJSONInnerMenu(@Path("id") Integer idMenu);

    @GET("/api/app/basket/")
    Call<GenBasket> getMyBasket(@Header("Authorization") String token);

    @GET("/api/app/basket/")
    Call<GenBasket> getMyBasketSendOrder(@Header("Authorization") String token,
                                         @Field("basket_position_id") Integer basket_pos_id);

    @GET("/api/app/basket/")
    Call<ExampleTimes> getMyTimes(@Header("Authorization") String token);

    @FormUrlEncoded
    @POST("/api/app/basket/")
    Call<GenBasket> decReaseButton(@Header("Authorization") String token,
                                   @Field("basket_position_id") Integer basket_pos_id,
                                   @Field("type") String type);

    @FormUrlEncoded
    @POST("/api/app/orders/")
    Call<GenOrders> getOrders(@Header("Authorization") String token,
                              @Field("type") String type);

    @FormUrlEncoded
    @POST("/api/app/orders/")
    Call<GenOrders> addOrderAgain(@Header("Authorization") String token,
                                  @Field("order_id") Integer orderId,
                                  @Field("type") String type);



    @POST("/api/app/order/")
    Call<ru.naparahandroid.fragmentproject.BasketModel.Example> postOrderDelivery(@Header("Authorization") String token,
                                                                                  @Body ru.naparahandroid.fragmentproject.BasketModel.Example body);

    @FormUrlEncoded
    @POST("/api/app/order/")
    Call<GenBasket> postOrderTakeOutFromRest(@Header("Authorization") String token,
                                             @Field("arriving") String arriving,
                                             @Field("cash_change") String cash_change,
                                             @Field("clientside_id") String clientside_id,
                                             @Field("comment") String comment,
                                             @Field("online_order") Boolean online_order,
                                             @Field("payment_type") String payment_type,
                                             @Field("people_amount") String people_amount,
                                             @Field("presence") String presence,
                                             @Field("remember_restaurant") Boolean remember_restaurant,
                                             @Field("restaurant_id") Integer restaurant_id,
                                             @Field("should_not_call") Boolean should_not_call);

    @FormUrlEncoded
    @POST("/api/app/order/")
    Call<GenBasket> postOrderInRest(@Header("Authorization") String token,
                                    @Field("arriving") String arriving,
                                    @Field("cash_change") String cash_change,
                                    @Field("clientside_id") String clientside_id,
                                    @Field("comment") String comment,
                                    @Field("online_order") String online_order,
                                    @Field("payment_type") String payment_type,
                                    @Field("people_amount") String people_amount,
                                    @Field("presence") String presence,
                                    @Field("remember_restaurant") Boolean remember_restaurant,
                                    @Field("restaurant_id") Integer restaurant_id,
                                    @Field("should_not_call") String should_not_call);






}
