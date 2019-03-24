package ru.ianasimonenko.fragmentproject;

import android.content.Intent;
import android.os.Bundle;
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
        RestaurantFragment.OnListFragmentInteractionListener, ProfileFragment.OnListFragmentInteractionListener,
        TempProdFragment.OnListFragmentInteractionListener,
        InfoFragment.OnListFragmentInteractionListener{
    private ActionBar toolbar;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Intent intent = getIntent();
//        token = intent.getStringExtra("access_token3");
//        Toast.makeText(HomeActivity.this, "Token"+token, Toast.LENGTH_SHORT).show();

        Toolbar topToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

        //BottomNavigationBar
        BottomNavigationView bottomNavigationView =
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (item -> {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.navigation_menu:
                            selectedFragment = ItemFragment.newInstance(0);
                            break;
                        case R.id.navigation_bonus:
                            selectedFragment = RestaurantFragment.newInstance(0);
                            break;
                        case R.id.navigation_profile:
                            selectedFragment = ProfileFragment.newInstance(0);
                            break;
                        case R.id.navigation_info:
                            selectedFragment = InfoFragment.newInstance(0);
                            break;
                    }

                    FragmentTransaction transaction = getSupportFragmentManager()
                            .beginTransaction();
                    assert selectedFragment != null;
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    return true;
                }
                );
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, ItemFragment.newInstance(0));
        transaction.commit();



    }


    public String getMyToken() {
        return "Bearer " + token + "!";
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
            Intent intent = new Intent(HomeActivity.this, InBasketOrdersActivity.class);
            startActivity(intent);
        }

        if(id == R.id.restart) {
            Toast.makeText(HomeActivity.this, "RESTART", Toast.LENGTH_LONG).show();
        }


        if(id == R.id.action_signout) {
            Toast.makeText(HomeActivity.this, "SignOut",
                    Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
