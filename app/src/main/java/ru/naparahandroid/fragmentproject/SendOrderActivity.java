package ru.naparahandroid.fragmentproject;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.Objects;

import ru.naparahandroid.fragmentproject.SendOrderFragments.ChooseOrderFragment;
import ru.naparahandroid.fragmentproject.SendOrderFragments.DeliveryFragment;
import ru.naparahandroid.fragmentproject.SendOrderFragments.InHouseFragment;
import ru.naparahandroid.fragmentproject.SendOrderFragments.TakeOutFragment;
import ru.naparahandroid.fragmentproject.SendOrderFragments.dummy.DummyContent;

public class SendOrderActivity extends AppCompatActivity implements DeliveryFragment.OnListFragmentInteractionListener, InHouseFragment.OnListFragmentInteractionListener,
                                                                    TakeOutFragment.OnListFragmentInteractionListener, ChooseOrderFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);

        Fragment choose = ChooseOrderFragment.newInstance(0);


        Toolbar toolbar = findViewById(R.id.toolbar_send_order);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_send_order);

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
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
            assert selectedFragment != null;
            transaction.replace(R.id.frame_layout_two, selectedFragment);
            transaction.commit();

            return true;
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
    public void onListFragmentInteraction() {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
