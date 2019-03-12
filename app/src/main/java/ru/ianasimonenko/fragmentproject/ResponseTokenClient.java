package ru.ianasimonenko.fragmentproject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ResponseTokenClient {

    @GET("/api/auth/token/")
    Call<JSONAccess> getAccessUser();



    @FormUrlEncoded
    @POST("/api/auth/token/")
    Call<AccessUser> login(@Field("phone") String phone, @Field("code") String code, @Field("policy") Boolean policy);

    @GET("secretinfo")
    Call<ResponseBody> getSecret(@Header("Authorization") String authToken);
}
