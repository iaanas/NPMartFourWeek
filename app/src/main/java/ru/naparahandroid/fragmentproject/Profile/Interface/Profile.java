package ru.naparahandroid.fragmentproject.Profile.Interface;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.naparahandroid.fragmentproject.Profile.Model.GET.ClientProfile;
import ru.naparahandroid.fragmentproject.Profile.Model.GET.Status;

public interface Profile {

    @GET("/api/client/data/")
    Call<JSONProfile> getJSON();

    @FormUrlEncoded
    @POST("/api/client/data/")
    Call<ClientProfile> signUp(@Header("Authorization") String token,
                               @Field("email") String email,
                               @Field("first_name") String firstName,
                               @Field("last_name") String lastName,
                               @Field("notify_about_orders_by_email") String notify,
                               @Field("type") String type);

    @GET("secretinfo")
    Call<Status> getSecret(@Header("Authorization") String authToken);
}
