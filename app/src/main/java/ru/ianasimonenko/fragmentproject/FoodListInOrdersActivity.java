package ru.ianasimonenko.fragmentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class FoodListInOrdersActivity extends AppCompatActivity {
    private ArrayList<Order> priceCount;

    private ListView listView;

    private OrdersDataAdapterTwo adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders_row);


        priceCount = new ArrayList<>();

        View parentView = findViewById(R.id.rowParent);

        listView = findViewById(R.id.list_products);

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
                    Toast.makeText(FoodListInOrdersActivity.this, "SUCCESS: "+response.body().getOrders().get(0).getNumber(), Toast.LENGTH_LONG).show();

                    adapter = new OrdersDataAdapterTwo(FoodListInOrdersActivity.this, priceCount);
                    listView.setAdapter(adapter);
                } else {
                    assert response.body() != null;
                    Toast.makeText(FoodListInOrdersActivity.this, "NOT SUCCESS: "+response.body().getOrders().get(0).getNumber(), Toast.LENGTH_LONG).show();
                }
            }

            @ParametersAreNonnullByDefault
            @Override
            public void onFailure(Call<GenOrders> call, Throwable t) {
                Toast.makeText(FoodListInOrdersActivity.this, "ERROR"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("ORDERS ERROR", t.getMessage());
            }
        });

    }
}
