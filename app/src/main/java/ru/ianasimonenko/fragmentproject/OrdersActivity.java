package ru.ianasimonenko.fragmentproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.OrdersModel.GenOrders;
import ru.ianasimonenko.fragmentproject.OrdersModel.Order;

public class OrdersActivity extends AppCompatActivity {

    private ArrayList<Order> priceCount;

    private ListView listView;

    private OrdersDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        priceCount = new ArrayList<>();

        View parentView = findViewById(R.id.parentLayoutOrders);

        listView = findViewById(R.id.listViewOrders);

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();


        ApiService api = RetrofitClient.getApiService();
        Call<GenOrders> call = api.getOrders(accessToken, "get");
        call.enqueue(new Callback<GenOrders>() {
            @Override
            public void onResponse(@NonNull Call<GenOrders> call, @NonNull Response<GenOrders> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    priceCount = (ArrayList<Order>) response.body().getOrders();

                    adapter = new OrdersDataAdapter(OrdersActivity.this, priceCount);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<GenOrders> call, @NonNull Throwable t) {

            }
        });


    }
}
