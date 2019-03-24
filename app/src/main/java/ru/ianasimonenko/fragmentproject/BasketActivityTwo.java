package ru.ianasimonenko.fragmentproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.annotation.ParametersAreNonnullByDefault;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.OrdersModel.GenOrders;
import ru.ianasimonenko.fragmentproject.OrdersModel.Order;

public class BasketActivityTwo extends AppCompatActivity {

    private ArrayList<Order> priceCount;

    private ListView listView;

    private OrdersDataAdapter adapter;

//    private TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_two);

        priceCount = new ArrayList<>();

        View parentView = findViewById(R.id.parentLayoutBasket2);

        listView = findViewById(R.id.listViewBasket2);

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();

        ApiService api = RetrofitClient.getApiService();
        Call<GenOrders> call = api.getOrders(accessToken, "get");
        call.enqueue(new Callback<GenOrders>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onResponse(Call<GenOrders> call, Response<GenOrders> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    priceCount = (ArrayList<Order>) response.body().getOrders();
                    Toast.makeText(BasketActivityTwo.this, "SUCCESS: "+response.body().getOrders().get(0).getNumber(), Toast.LENGTH_LONG).show();

                    adapter = new OrdersDataAdapter(BasketActivityTwo.this, priceCount);
                    listView.setAdapter(adapter);
                } else {
                    assert response.body() != null;
                    Toast.makeText(BasketActivityTwo.this, "NOT SUCCESS: "+response.body().getOrders().get(0).getNumber(), Toast.LENGTH_LONG).show();
                }
            }

            @ParametersAreNonnullByDefault
            @Override
            public void onFailure(Call<GenOrders> call, Throwable t) {
                Toast.makeText(BasketActivityTwo.this, "ERROR"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("ORDERS ERROR", t.getMessage());
            }
        });


    }

}
