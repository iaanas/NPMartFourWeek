package ru.ianasimonenko.fragmentproject;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.Objects;

public class InBasketOrdersActivity extends AppCompatActivity implements InCartFragment.OnListFragmentInteractionListener, InOrdersFragment.OnListFragmentInteractionListener,
                                                                         TotalBasketFragment.OnListFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_basket_orders);

        Fragment totalBasket = TotalBasketFragment.newInstance(0);


        Toolbar toolbar = findViewById(R.id.toolbarBO);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBO);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (item -> {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.bo_cart:
                            selectedFragment = InCartFragment.newInstance(0);
                            break;
                        case R.id.bo_order:
                            selectedFragment = InOrdersFragment.newInstance(0);
                            break;
                    }

                    FragmentTransaction transaction = getSupportFragmentManager()
                            .beginTransaction();
                    assert selectedFragment != null;
                    transaction.replace(R.id.frame_layout_bo, selectedFragment);
                    transaction.commit();

//                         FragmentTransaction transaction1 = getSupportFragmentManager()
//                                 .beginTransaction();
//                         transaction1.add(R.id.frame_layout_total, totalBasket);
//                         transaction1.commit();

                    return true;
                }
                );

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_bo, InCartFragment.newInstance(0));
        transaction.commit();

        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.add(R.id.frame_layout_total, totalBasket);
        transaction1.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
            this.finish();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }


}
