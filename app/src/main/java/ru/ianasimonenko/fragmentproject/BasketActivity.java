package ru.ianasimonenko.fragmentproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;

public class BasketActivity extends AppCompatActivity {

    private ArrayList<BasketPosition> priceCount;

    private View parentView;
    private ListView listView;

    private BasketDataAdapterOld adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        priceCount = new ArrayList<>();

        parentView = findViewById(R.id.parentLayoutBasket);

        listView = (ListView) findViewById(R.id.listViewBasket);

        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasket("Bearer ccec704dc2854ace9141a609174cf92a");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {
                    priceCount = (ArrayList<BasketPosition>) response.body().getBasketPositions();

                    adapter = new BasketDataAdapterOld(BasketActivity.this, priceCount);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {

            }
        });


    }

}
