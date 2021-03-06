package ru.ianasimonenko.fragmentproject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PhoneAuthClient {

    @POST("/api/auth/code/")
    @FormUrlEncoded
    Call<PhoneAuthModel> savePhone(@Field("phone") String phone);
}
