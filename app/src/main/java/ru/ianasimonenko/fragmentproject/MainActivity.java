package ru.ianasimonenko.fragmentproject;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.ianasimonenko.fragmentproject.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void onListFragmentInteraction(MyMenuAdapter item) {

    }
}
