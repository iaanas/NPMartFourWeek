package ru.ianasimonenko.fragmentproject.SendOrderFragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.ApiService;
import ru.ianasimonenko.fragmentproject.BasketActivity;
import ru.ianasimonenko.fragmentproject.BasketDataAdapterOld;
import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.BasketModel.Client;
import ru.ianasimonenko.fragmentproject.BasketModel.DeliveryTime;
import ru.ianasimonenko.fragmentproject.BasketModel.ExampleTimes;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;
import ru.ianasimonenko.fragmentproject.R;
import ru.ianasimonenko.fragmentproject.RetrofitClient;

public class InHouseActivity extends AppCompatActivity {

    private ArrayList<BasketPosition> priceCount;

    private View parentView;
    private ListView listView;

    private Integer rest_id;

    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox checkBox;

    private Spinner spinnerTime;
    private Spinner spinnerPeoples;
    private TextView selectionSpinner;

    private Button sendOrder;
    private String selected;
    private String selected2;
    private String clientsideId;

    private EditText commentView;
    private Integer peoples;
    private Boolean checked;
    private String accessToken;

//    private InHouseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_house);

        priceCount = new ArrayList<>();
        parentView = findViewById(R.id.parentLayoutBasket);

        //View
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioButton = (RadioButton) findViewById(R.id.radio_one);
        radioButton.setText("В. О. - 7-я линия В.О., д. 63");

        radioButton = (RadioButton) findViewById(R.id.radio_two);
        radioButton.setText("Марата - Марата, 69-71");

        radioButton = (RadioButton) findViewById(R.id.radio_three);
        radioButton.setText("Спортивная - Большой проспект, д. 49");

        radioButton = (RadioButton) findViewById(R.id.radio_for);
        radioButton.setText("Дыбенко - Мурманское Шоссе, д. 63");

        radioButton = (RadioButton) findViewById(R.id.radio_five);
        radioButton.setText("Литейный - Литейный, д. 352");

        radioButton = (RadioButton) findViewById(R.id.radio_six);
        radioButton.setText("Ленинский - Бульвар Новаторов, д. 10");

        radioButton = (RadioButton) findViewById(R.id.radio_seven);
        radioButton.setText("Пионерская - Коломяжский проспект, 15А");

        radioButton = (RadioButton) findViewById(R.id.radio_eight);
        radioButton.setText("Гостиный - Садовая улица, д. 55");

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checked = checkBox.isChecked();


        //Spinner

        spinnerTime = (Spinner) findViewById(R.id.spinner_time);
        selected = spinnerTime.getSelectedItem().toString();

        spinnerPeoples = (Spinner) findViewById(R.id.spinner_peoples);
        selected2 = spinnerPeoples.getSelectedItem().toString();

        //Views
        commentView = (EditText) findViewById(R.id.comment);
        String comment = commentView.getText().toString();

        sendOrder = (Button) findViewById(R.id.send_orders);







//        listView = (ListView) findViewById(R.id.listViewBasket);

        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasket("Bearer ccec704dc2854ace9141a609174cf92a");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {


                    rest_id = response.body().getClient().getRestaurantId();
                    Toast.makeText(InHouseActivity.this, "SUCCESS", Toast.LENGTH_LONG).show();

                    sendOrder.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sendOrder(selected, comment, selected2, checked, rest_id);
                        }
                    });

                } else {
                    Toast.makeText(InHouseActivity.this, "NOT SUCCESS"+rest_id, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {
                Toast.makeText(InHouseActivity.this, "ERROR: "+rest_id, Toast.LENGTH_LONG).show();
            }
        });

    }

    public void getBasketForOrder(Integer basket_pos_id, String comment) {
        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasketSendOrder("Bearer ccec704dc2854ace9141a609174cf92a", basket_pos_id);
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {


                    rest_id = response.body().getClient().getRestaurantId();
                    Toast.makeText(InHouseActivity.this, "SUCCESS", Toast.LENGTH_LONG).show();

                    sendOrder.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sendOrder(selected, comment, selected2, checked, rest_id);
                        }
                    });


//                    adapter = new InHouseAdapter(InHouseActivity.this, priceCount);
//                    listView.setAdapter(adapter);
                } else {
                    Toast.makeText(InHouseActivity.this, "NOT SUCCESS"+rest_id, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {
                Toast.makeText(InHouseActivity.this, "ERROR: "+rest_id, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void sendOrder(String selected, String comment, String selected2, Boolean checked, Integer rest_id) {

        String clientId = UUID.randomUUID().toString();
        String clientIdClean = clientId.replaceAll("-", "");

        clientsideId = clientIdClean.substring(0, 16);


        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.postOrderInRest("Bearer ccec704dc2854ace9141a609174cf92a", selected, null,
                                                    "VsU5h3d0FzWH3khL", comment, false, "", selected2, "stay",
                                                    true, rest_id, false);
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(InHouseActivity.this, "SUCCESS", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(InHouseActivity.this, "NOT SUCCESS: "+clientsideId, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {
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
