package ru.ianasimonenko.fragmentproject;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.ianasimonenko.fragmentproject.Model.Example;

public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("/api/app/menus/")
    Call<Example> getMyJSON();
}
