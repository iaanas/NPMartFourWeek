package ru.naparahandroid.fragmentproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import javax.annotation.ParametersAreNonnullByDefault;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.naparahandroid.fragmentproject.BasketModel.BasketPosition;
import ru.naparahandroid.fragmentproject.BasketModel.GenBasket;

public class BasketActivity extends AppCompatActivity {

    private ArrayList<BasketPosition> priceCount;

    private ListView listView;

    private BasketDataAdapterOld adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        priceCount = new ArrayList<>();

        View parentView = findViewById(R.id.parentLayoutBasket);

        listView = findViewById(R.id.listViewBasket);

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();

        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasket(accessToken);
        call.enqueue(new Callback<GenBasket>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    priceCount = (ArrayList<BasketPosition>) response.body().getBasketPositions();

                    adapter = new BasketDataAdapterOld(BasketActivity.this, priceCount);
                    listView.setAdapter(adapter);
                }
            }

            @ParametersAreNonnullByDefault
            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {

            }
        });


    }

}
