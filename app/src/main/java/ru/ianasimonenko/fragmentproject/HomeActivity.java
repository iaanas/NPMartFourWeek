package ru.ianasimonenko.fragmentproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ru.ianasimonenko.fragmentproject.dummy.DummyContent;

public class HomeActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener,
        RestaurantFragment.OnListFragmentInteractionListener {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar topToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

        //BottomNavigationBar
        BottomNavigationView bottomNavigationView =
                (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                     @Override
                     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                         Fragment selectedFragment = null;
                         switch (item.getItemId()) {
                             case R.id.navigation_menu:
                                 selectedFragment = ItemFragment.newInstance(0);
                                 break;
                             case R.id.navigation_bonus:
                                 selectedFragment = RestaurantFragment.newInstance(0);
                                 break;
//                             case R.id.navigation_profile:
//                                 selectedFragment = ProfileFragment.newInstance();
//                             case R.id.navigation_info:
//                                 selectedFragment = InfoFragment.newInstance();
                         }

                         FragmentTransaction transaction = getSupportFragmentManager()
                                 .beginTransaction();
                         transaction.replace(R.id.frame_layout, selectedFragment);
                         transaction.commit();
                         return true;
                     }
                 }
                );
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, ItemFragment.newInstance(0));
        transaction.commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

//        if(id == R.id.action_settings) return true;

        if(id == R.id.action_cart) {
            Intent intent = new Intent(HomeActivity.this, BasketActivity.class);
            startActivity(intent);
        }


        if(id == R.id.action_signout) {
            Toast.makeText(HomeActivity.this, "Create Text",
                    Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(MyMenuAdapter item) {

    }


    @Override
    public void onListFragmentInteraction(DataRestaurantAdapter item) {

    }
}
