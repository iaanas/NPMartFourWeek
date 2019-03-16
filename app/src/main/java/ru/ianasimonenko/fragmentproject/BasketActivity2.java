package ru.ianasimonenko.fragmentproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.OrdersModel.GenOrders;
import ru.ianasimonenko.fragmentproject.OrdersModel.Order;

public class BasketActivity2 extends AppCompatActivity {

    private ArrayList<Order> priceCount;

    private View parentView;
    private ListView listView;

    private OrdersDataAdapter adapter;

    private TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket2);

        priceCount = new ArrayList<>();

        parentView = findViewById(R.id.parentLayoutBasket2);

        listView = (ListView) findViewById(R.id.listViewBasket2);

        ApiService api = RetrofitClient.getApiService();
        Call<GenOrders> call = api.getOrders("Bearer ccec704dc2854ace9141a609174cf92a", "get");
        call.enqueue(new Callback<GenOrders>() {
            @Override
            public void onResponse(Call<GenOrders> call, Response<GenOrders> response) {
                if (response.isSuccessful()) {
                    priceCount = (ArrayList<Order>) response.body().getOrders();
                    Toast.makeText(BasketActivity2.this, "SUCCESS: "+response.body().getOrders().get(0).getNumber(), Toast.LENGTH_LONG).show();

                    adapter = new OrdersDataAdapter(BasketActivity2.this, priceCount);
                    listView.setAdapter(adapter);
                } else {
                    Toast.makeText(BasketActivity2.this, "NOT SUCCESS: "+response.body().getOrders().get(0).getNumber(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GenOrders> call, Throwable t) {
                Toast.makeText(BasketActivity2.this, "ERROR"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("ORDERS ERROR", t.getMessage());
            }
        });


    }

}
