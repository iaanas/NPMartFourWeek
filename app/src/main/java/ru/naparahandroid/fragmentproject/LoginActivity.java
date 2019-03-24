package ru.naparahandroid.fragmentproject;

import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import ru.naparahandroid.fragmentproject.SendOrderFragments.InHouseFragment;

public class LoginActivity extends AppCompatActivity implements InHouseFragment.OnListFragmentInteractionListener {

    private static String token;
    private String testToken;
    private Intent intent2;


    private final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://naparah.olegb.ru/")
            .addConverterFactory(GsonConverterFactory.create());

    private final Retrofit retrofit = builder.build();
    private final ResponseTokenClient userClient = retrofit.create(ResponseTokenClient.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        testToken = "jkjkjhgjhgjh";


        findViewById(R.id.btn_login).setOnClickListener(
                (view) -> login()
        );

//        findViewById(R.id.btn_secret).setOnClickListener(
//                (view) -> { getSecret(); }
//        );

    }

    private static Boolean needDataUser;

    private void login() {
        Intent phoneCode = getIntent();
        String phone = phoneCode.getStringExtra("phone");


        EditText code = findViewById(R.id.et_code);
        String codeIn = code.getText().toString();

//        AuthUser login = new AuthUser(1111111111, 2341, true);
        Call<AccessUser> call = userClient.login(phone, codeIn, true);

        call.enqueue(new Callback<AccessUser>() {
            @Override
            public void onResponse(@NonNull Call<AccessUser> call, @NonNull Response<AccessUser> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Toast.makeText(LoginActivity.this,
                            response.body().getAccessToken() + " : " + response.body().getNeedUserData(),
                            Toast.LENGTH_LONG).show();
                    if (response.body() != null) {
                        token = response.body().getAccessToken();
                        needDataUser = response.body().getNeedUserData();


                        if (needDataUser) {
                            Intent intent = new Intent(LoginActivity.this, EditProfileActivity.class);
                            intent.putExtra("access_token2", response.body().getAccessToken());
                            startActivity(intent);
                        } else {
                            intent2 = new Intent(LoginActivity.this, HomeActivity.class);
                            intent2.putExtra("access_token", ""+ token);
                            startActivity(intent2);

                        }
                    }

                }
                else {
                    Toast.makeText(LoginActivity.this, "Code is not correct" + phone + " : " + codeIn,
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AccessUser> call, @NonNull Throwable t) {
                Toast.makeText(LoginActivity.this, "error it",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    public String getMyTokenFromLogin() {
        testToken = token;
        return "Bearer "+testToken;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private void getSecret() {
        Call<ResponseBody> call = userClient.getSecret(token);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        assert response.body() != null;
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
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {

            }
        });


    }


    @Override
    public void onListFragmentInteraction() {

    }

    public String saveToken() {
        SharedPreferences sToken = getPreferences(MODE_PRIVATE);
        return sToken.getString(token, "");
    }

}