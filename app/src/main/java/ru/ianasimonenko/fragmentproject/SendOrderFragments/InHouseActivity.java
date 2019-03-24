package ru.ianasimonenko.fragmentproject.SendOrderFragments;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.ParametersAreNonnullByDefault;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.ApiService;
import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;
import ru.ianasimonenko.fragmentproject.LoginActivity;
import ru.ianasimonenko.fragmentproject.R;
import ru.ianasimonenko.fragmentproject.RetrofitClient;

public class InHouseActivity extends AppCompatActivity {

    private ListView listView;

    private Integer rest_id;

    private TextView selectionSpinner;

    private Button sendOrder;
    private String selected;
    private String selected2;
    private String clientsideId;

    private Integer peoples;
    private Boolean checked;
    private String accessToken;

//    private InHouseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_house);

        ArrayList<BasketPosition> priceCount = new ArrayList<>();
        View parentView = findViewById(R.id.parentLayoutBasket);

        //View
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        RadioButton radioButton = findViewById(R.id.radio_one);
        String BUTTON_ONE = "В. О. - 7-я линия В.О., д. 63";
        radioButton.setText(BUTTON_ONE);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = findViewById(R.id.radio_two);
        String BUTTON_TWO = "Марата - Марата, 69-71";
        radioButton.setText(BUTTON_TWO);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = findViewById(R.id.radio_three);
        String BUTTON_THREE = "Спортивная - Большой проспект, д. 49";
        radioButton.setText(BUTTON_THREE);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = findViewById(R.id.radio_for);
        String BUTTON_FOUR = "Дыбенко - Мурманское Шоссе, д. 63";
        radioButton.setText(BUTTON_FOUR);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = findViewById(R.id.radio_five);
        String BUTTON_FIVE = "Литейный - Литейный, д. 352";
        radioButton.setText(BUTTON_FIVE);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = findViewById(R.id.radio_six);
        String BUTTON_SIX = "Ленинский - Бульвар Новаторов, д. 10";
        radioButton.setText(BUTTON_SIX);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = findViewById(R.id.radio_seven);
        String BUTTON_SEVEN = "Пионерская - Коломяжский проспект, 15А";
        radioButton.setText(BUTTON_SEVEN);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = findViewById(R.id.radio_eight);
        String BUTTON_EIGHT = "Гостиный - Садовая улица, д. 55";
        radioButton.setText(BUTTON_EIGHT);
        radioButton.setOnClickListener(radioButtonClickListener);


        CheckBox checkBox = findViewById(R.id.checkBox);
        checked = checkBox.isChecked();


        //Spinner

        Spinner spinnerTime = findViewById(R.id.spinner_time);
        selected = spinnerTime.getSelectedItem().toString();

        Spinner spinnerPeoples = findViewById(R.id.spinner_peoples);
        selected2 = spinnerPeoples.getSelectedItem().toString();

        //Views
        EditText commentView = findViewById(R.id.comment);
        String comment = commentView.getText().toString();

        sendOrder = findViewById(R.id.send_orders);

        LoginActivity activity = new LoginActivity();
        accessToken = activity.getMyTokenFromLogin();


//        listView = (ListView) findViewById(R.id.listViewBasket);

        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasket(accessToken);
        call.enqueue(new Callback<GenBasket>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {


                    assert response.body() != null;
                    rest_id = response.body().getClient().getRestaurantId();
                    Toast.makeText(InHouseActivity.this, "SUCCESS", Toast.LENGTH_LONG).show();

                    sendOrder.setOnClickListener(v -> sendOrder(selected, comment, selected2, checked, rest_id));

                } else {
                    Toast.makeText(InHouseActivity.this, "NOT SUCCESS"+rest_id, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GenBasket> call, @NonNull Throwable t) {
                Toast.makeText(InHouseActivity.this, "ERROR: "+rest_id, Toast.LENGTH_LONG).show();
            }
        });

    }

    private final View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radio_one:
                    rest_id = 13;
                    break;
                case R.id.radio_two:
                    rest_id = 10;
                    break;
                case R.id.radio_three:
                    rest_id = 9;
                    break;
                case R.id.radio_for:
                    rest_id = 12;
                case R.id.radio_five:
                    rest_id = 11;
                    break;
                case R.id.radio_six:
                    rest_id = 8;
                    break;
                case R.id.radio_seven:
                    rest_id = 7;
                    break;
                case R.id.radio_eight:
                    rest_id = 6;
            }
        }
    };

    public void getBasketForOrder(Integer basket_pos_id, String comment) {
        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasketSendOrder(accessToken, basket_pos_id);
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(@NonNull Call<GenBasket> call, @NonNull Response<GenBasket> response) {
                if (response.isSuccessful()) {


                    assert response.body() != null;
                    rest_id = response.body().getClient().getRestaurantId();
                    Toast.makeText(InHouseActivity.this, "SUCCESS", Toast.LENGTH_LONG).show();

                    sendOrder.setOnClickListener(v -> sendOrder(selected, comment, selected2, checked, rest_id));


//                    adapter = new InHouseAdapter(InHouseActivity.this, priceCount);
//                    listView.setAdapter(adapter);
                } else {
                    Toast.makeText(InHouseActivity.this, "NOT SUCCESS"+rest_id, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GenBasket> call, @NonNull Throwable t) {
                Toast.makeText(InHouseActivity.this, "ERROR: "+rest_id, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void sendOrder(String selected, String comment, String selected2, Boolean checked, Integer rest_id) {

        String clientId = UUID.randomUUID().toString();
        String clientIdClean = clientId.replaceAll("-", "");

        clientsideId = clientIdClean.substring(0, 16);


        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.postOrderInRest(accessToken, selected, null,
                                                    clientsideId, comment, "False", "", selected2, "stay",
                                                    true, rest_id, "False");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(@NonNull Call<GenBasket> call, @NonNull Response<GenBasket> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(InHouseActivity.this, "SUCCESS", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(InHouseActivity.this, "NOT SUCCESS: "+clientsideId, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GenBasket> call, @NonNull Throwable t) {
                Toast.makeText(InHouseActivity.this, "ERROR: "+rest_id, Toast.LENGTH_LONG).show();
            }
        });

    }


//    public class InHouseAdapter extends ArrayAdapter<BasketPosition> {
//
//        List<BasketPosition> list;
//
//        Context context;
//        private LayoutInflater inflater;
//
//        String rest_id;
//
//
//        public InHouseAdapter(Context context, List<BasketPosition> objects) {
//            super(context, 0, objects);
//
//            this.context = context;
//            this.inflater = LayoutInflater.from(context);
//            list = objects;
//        }
//
//        @Override
//        public BasketPosition getItem(int position) {
//            return list.get(position);
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            final ViewHolder vh;
//
//            if (convertView == null) {
//                View view = inflater.inflate(R.layout.in_house_row, parent, false);
//                vh = ViewHolder.create((RelativeLayout) view);
//                view.setTag(vh);
//            } else {
//                vh = (ViewHolder) convertView.getTag();
//            }
//
//            BasketPosition item = getItem(position);
//
//
//
//            vh.name_of_position.setText(item.getPosition().getName());
//
//            return vh.rootView;
//
//        }
//
//        private static class ViewHolder {
//
//            public final RelativeLayout rootView;
//            public final RadioGroup radioGroup;
//
//            private ViewHolder(RelativeLayout rootView, RadioGroup radioGroup) {
//                this.rootView = rootView;
//                this.radioGroup = radioGroup;
//            }
//
//            public static ViewHolder create(RelativeLayout rootView) {
//                RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radio_group);
//
//                return new ViewHolder(rootView, radioGroup);
//            }
//
//        }
//    }
}
