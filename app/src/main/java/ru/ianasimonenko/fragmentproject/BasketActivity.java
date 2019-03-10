package ru.ianasimonenko.fragmentproject;

import android.app.Activity;
import android.os.Bundle;

public class BasketActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
    }
}
