package ru.ianasimonenko.fragmentproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

public class PhoneAuthActivity extends AppCompatActivity {

    private TextView mResponseTv;
    private PhoneAuthClient mAPIService;

    private String phoneCleaned;
    private String phoneClenedTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);

        final EditText phone = (EditText) findViewById(R.id.et_phone);



        FormatWatcher formatWatcher2 = new MaskFormatWatcher(
                MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER) // маска
        );
        formatWatcher2.installOn(phone);

        Button submitBtn = (Button) findViewById(R.id.btn_submit);

        mResponseTv = (TextView) findViewById(R.id.tv_response);

        mAPIService = ApiUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(PhoneAuthActivity.this, LoginActivity.class);
            @Override
            public void onClick(View v) {
                String phoneAuth = phone.getText().toString();
                phoneCleaned = phoneAuth.replaceAll("[+7()-]", "");
                phoneClenedTwo = phoneCleaned.replaceAll(" ", "");
                if(!TextUtils.isEmpty(phoneAuth)) {
                    sendPost(phoneAuth);
                    intent.putExtra("phone", phoneClenedTwo);
                    startActivity(intent);
                }
            }
        });

    }
    public void sendPost(String phoneAuth) {
        mAPIService.savePhone(phoneAuth).enqueue(new Callback<PhoneAuthModel>() {
            @Override
            public void onResponse(Call<PhoneAuthModel> call, Response<PhoneAuthModel> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(PhoneAuthActivity.this, "Tel: "+ phoneClenedTwo, Toast.LENGTH_LONG).show();
//                    showResponse(response.body().toString());
//                    Log.i("SUCCESS", "post submitted to API." + response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<PhoneAuthModel> call, Throwable t) {
                Log.e("ERROR", "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}
