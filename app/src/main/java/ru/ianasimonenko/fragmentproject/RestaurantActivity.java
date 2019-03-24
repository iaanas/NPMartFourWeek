package ru.ianasimonenko.fragmentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class RestaurantActivity extends AppCompatActivity implements RestaurantFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
    }


}
