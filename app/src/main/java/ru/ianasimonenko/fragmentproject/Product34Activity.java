package ru.ianasimonenko.fragmentproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ianasimonenko.fragmentproject.Products.GenProducts;
import ru.ianasimonenko.fragmentproject.Products.Interface.ProductsClient;
import ru.ianasimonenko.fragmentproject.Products.Model24.Prod24Gen;

public class Product34Activity extends AppCompatActivity {

    private Toolbar toolbar;

    private ListView listView;
    private View parentView;

    private List<GenProducts> prod34List;
    private ProdAdapter adapter;


    private ImageView image34;
    private TextView name34;
    private TextView price34;
    private TextView grams34;
    private TextView callories34;
    private TextView description34;

    private Button button;

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://naparah.olegb.ru/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();
    ProductsClient prod34 = retrofit.create(ProductsClient.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_34_test);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button) findViewById(R.id.btnToBusket);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prodOnServer();

            }
        });


        //Parsing JSON

        Call<GenProducts> call = prod34.get24JSON();

        call.enqueue(new Callback<GenProducts>() {
            @Override
            public void onResponse(Call<GenProducts> call, Response<GenProducts> response) {

                if(response.isSuccessful()) {

                    Toast.makeText(Product34Activity.this, "Продукт успешно получен с сервера " + response.body().getDish().getName(),
                            Toast.LENGTH_SHORT).show();

                    Picasso.with(Product34Activity.this).load(String.valueOf(response.body().getDish().getImages().get(0))).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(
                            (ImageView) findViewById(R.id.product_image));
//                    image34.setImageURI(Uri.parse(String.valueOf(response.body().getDish().getImages())));

                    name34 = (TextView) findViewById(R.id.product_name);
                    name34.setText(response.body().getDish().getName());

                    price34 = (TextView) findViewById(R.id.product_price);
                    String price = String.valueOf(response.body().getDish().getPrice()) + " p.";
                    price34.setText(price);
//
                    grams34 = (TextView) findViewById(R.id.product_grams);
                    String grams = String.valueOf(response.body().getDish().getGrams()) + " гр.";
                    grams34.setText(grams);
//
                    callories34 = (TextView) findViewById(R.id.product_calories);
                    String callories = String.valueOf(response.body().getDish().getCalories()) + " ккал";
                    callories34.setText(callories);
//
                    description34 = (TextView) findViewById(R.id.product_description);
                    description34.setText(response.body().getDish().getDescription());

//                    prod34List = (List<GenProducts>) response.body().getDish();
//
//                    adapter = new ProdAdapter(Product34Activity.this, prod34List);
//                    listView.setAdapter(adapter);

                } else {
                }
            }

            @Override
            public void onFailure(Call<GenProducts> call, Throwable t) {

            }
        });


    }

    public void prodOnServer() {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://naparah.olegb.ru/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        ProductsClient userClient = retrofit.create(ProductsClient.class);

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();

        Call<Prod24Gen> call = userClient.prodToBusket(accessToken, null,97, null,"add");

        call.enqueue(new Callback<Prod24Gen>() {
            @Override
            public void onResponse(Call<Prod24Gen> call, Response<Prod24Gen> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(Product34Activity.this, "ПРОДУКТ ДОБАВЛЕН В КОРЗИНУ НА СЕРВЕРЕ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Product34Activity.this, "ПРОДУКТ НЕ ДОБАВЛЕН В КОРЗИНУ НА СЕРВЕРЕ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Prod24Gen> call, Throwable t) {
                Toast.makeText(Product34Activity.this, "ОШИБКА",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

//        if(id == R.id.action_settings) return true;

        if(id == R.id.action_cart) {
            Intent intent = new Intent(Product34Activity.this, InBasketOrdersActivity.class);
            startActivity(intent);
        }


        if(id == R.id.action_signout) {
            Toast.makeText(Product34Activity.this, "Create Text",
                    Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
