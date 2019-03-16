package ru.ianasimonenko.fragmentproject;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ru.ianasimonenko.fragmentproject.SendOrderFragments.ChooseOrderFragment;
import ru.ianasimonenko.fragmentproject.SendOrderFragments.DeliveryFragment;
import ru.ianasimonenko.fragmentproject.SendOrderFragments.InHouseFragment;
import ru.ianasimonenko.fragmentproject.SendOrderFragments.TakeOutFragment;
import ru.ianasimonenko.fragmentproject.SendOrderFragments.dummy.DummyContent;

public class SendOrderActivity extends AppCompatActivity implements DeliveryFragment.OnListFragmentInteractionListener, InHouseFragment.OnListFragmentInteractionListener,
                                                                    TakeOutFragment.OnListFragmentInteractionListener, ChooseOrderFragment.OnListFragmentInteractionListener{
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);

        Fragment choose = ChooseOrderFragment.newInstance(0);


        toolbar = (Toolbar) findViewById(R.id.toolbar_send_order);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation_send_order);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.send_delivery:
                        selectedFragment = DeliveryFragment.newInstance(0);
                        break;
                    case R.id.send_in_house:
                        selectedFragment = InHouseFragment.newInstance(0);
                        break;
                    case R.id.send_take_out:
                        selectedFragment = TakeOutFragment.newInstance(0);
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout_two, selectedFragment);
                transaction.commit();

                return true;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_two, DeliveryFragment.newInstance(0));
        transaction.commit();

        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.replace(R.id.frame_layout_one, choose);
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

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
