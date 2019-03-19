package ru.ianasimonenko.fragmentproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ianasimonenko.fragmentproject.Profile.Interface.Profile;
import ru.ianasimonenko.fragmentproject.Profile.Model.GET.Client;

public class EditProfileActivity extends AppCompatActivity {


    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://naparah.olegb.ru/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();
    Profile userClient = retrofit.create(Profile.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
//        CookieManager cookieManager = new CookieManager(new PersistentCookieStore(EditProfileActivity.this), CookiePolicy.ACCEPT_ORIGINAL_SERVER);
//        CookieHandler.setContext(cookieManager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        findViewById(R.id.buttonSave).setOnClickListener(
                (view) -> { login(); }
        );


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void login() {

        //var
        TextView birthDay = (TextView) findViewById(R.id.birthday);

        EditText email = (EditText) findViewById(R.id.editTextEmail);
        String emailStr = email.getText().toString();

        EditText firstName = (EditText) findViewById(R.id.editFirstName);
        String firstNameStr = firstName.getText().toString();

        EditText lastName = (EditText) findViewById(R.id.editLastName);
        String lastNameStr = lastName.getText().toString();

//        Intent intent = getIntent();
//        String token = intent.getStringExtra("access_token");
        String token= "ccec704dc2854ace9141a609174cf92a";

        EditText phone = (EditText) findViewById(R.id.editTextPhone);
        String phoneStr = phone.getText().toString();

        CheckBox notify = (CheckBox) findViewById(R.id.checkbox);

        String notBool = String.valueOf(notify.isChecked());


        String type = "change_user_info";


//        Birthday birthday = new Birthday(1, 5, 1988);
//        ProfileIn profileIn = new ProfileIn(birthday, emailStr, firstNameStr, lastNameStr, "3a5bca756710470da5112acd7f8fcde3", phoneStr, nitOrdByEmail, type);
        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();

        Call<Client> call = userClient.signUp(accessToken, emailStr, firstNameStr, lastNameStr, "True", type);

        call.enqueue(new Callback<Client>() {

            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {

                if(response.isSuccessful()) {


                    Toast.makeText(EditProfileActivity.this, "ПРОФИЛЬ СОЗДАН!", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(EditProfileActivity.this, "ERROR!!!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Toast.makeText(EditProfileActivity.this, "SOS!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
