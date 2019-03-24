package ru.naparahandroid.fragmentproject.Profile.Interface;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.naparahandroid.fragmentproject.Profile.Model.GET.Status;

public interface ProfileGet {

    @GET("/api/client/data/")
    Call<JSONClient> getJSON(@Query("phone") String phone,
                             @Query("first_name") String fname,
                             @Query("last_name") String lname,
                             @Query("email") String slug,
                             @Query("successful_orders") Integer orders);

    @FormUrlEncoded
    @POST("/api/client/data/")
    Call<Status> getProfile(@Header("Authorization") String token,
                            @Field("type") String type);
}
