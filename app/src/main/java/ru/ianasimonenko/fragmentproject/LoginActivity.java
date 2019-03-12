package ru.ianasimonenko.fragmentproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://naparah.olegb.ru/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();
    ResponseTokenClient userClient = retrofit.create(ResponseTokenClient.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        findViewById(R.id.btn_login).setOnClickListener(
                (view) -> { login(); }
        );

//        findViewById(R.id.btn_secret).setOnClickListener(
//                (view) -> { getSecret(); }
//        );

    }

    private static String token;
    private static Boolean needDataUser;

    private void login() {
        Intent phoneCode = getIntent();
        String phone = phoneCode.getStringExtra("phone");


        EditText code = (EditText) findViewById(R.id.et_code);
        String codeIn = code.getText().toString();

//        AuthUser login = new AuthUser(1111111111, 2341, true);
        Call<AccessUser> call = userClient.login(phone, codeIn, true);

        call.enqueue(new Callback<AccessUser>() {
            @Override
            public void onResponse(Call<AccessUser> call, Response<AccessUser> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this,
                            response.body().getAccessToken() + " : " + response.body().getNeedUserData(),
                            Toast.LENGTH_LONG).show();
                    if (response.body() != null) {
                        token = response.body().getAccessToken();
                        needDataUser = response.body().getNeedUserData();

                        if (needDataUser) {
                            Intent intent = new Intent(LoginActivity.this, EditProfileActivity.class);
                            intent.putExtra("access_token", response.body().getAccessToken());
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            intent.putExtra("access_token", token);
                            startActivity(intent);
                        }
                    }

                }
                else {
                    Toast.makeText(LoginActivity.this, "Code is not correct" + phone + " : " + codeIn,
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AccessUser> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "error it",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getSecret() {
        Call<ResponseBody> call = userClient.getSecret(token);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        Toast.makeText(LoginActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this, "Code is not correct", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }



}