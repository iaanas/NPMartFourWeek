package ru.naparahandroid.fragmentproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.naparahandroid.fragmentproject.InnerMenu.Category;
import ru.naparahandroid.fragmentproject.InnerMenu.Example;

public class InnerMenuActivity extends AppCompatActivity implements InnerMenuFragment.OnFragmentInteractionListener {
    private ListView listView;

    private ArrayList<Category> menuItemList;
    private MyInnerMenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_menu);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_inner_menu, InnerMenuFragment.newInstance("1", "2"));
        transaction.commit();

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));


        menuItemList = new ArrayList<>();
        listView = findViewById(R.id.list_inner_menu);
        ApiService api = RetrofitClient.getApiService();
        Call<Example> call = api.getMyJSONInnerMenu(Integer.valueOf(getIntent().getStringExtra("idInnerMenu")));
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                assert response.body() != null;
                menuItemList = (ArrayList<Category>) response.body().getCategories();

                adapter = new MyInnerMenuAdapter(InnerMenuActivity.this, menuItemList);
                listView.setAdapter(adapter);

            }


            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });


    }

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String idAdapter = intent.getStringExtra("id");
            Toast.makeText(InnerMenuActivity.this, "ID: "+idAdapter,
                    Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
