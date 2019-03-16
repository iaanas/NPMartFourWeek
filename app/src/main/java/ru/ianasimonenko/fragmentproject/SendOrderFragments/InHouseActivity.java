package ru.ianasimonenko.fragmentproject.SendOrderFragments;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.ApiService;
import ru.ianasimonenko.fragmentproject.BasketActivity;
import ru.ianasimonenko.fragmentproject.BasketDataAdapterOld;
import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.BasketModel.Client;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;
import ru.ianasimonenko.fragmentproject.R;
import ru.ianasimonenko.fragmentproject.RetrofitClient;

public class InHouseActivity extends AppCompatActivity {

    private ArrayList<BasketPosition> priceCount;

    private View parentView;
    private ListView listView;

    private String rest_id;

    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox checkBox;

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


        radioButton = (RadioButton) findViewById(R.id.radio_2_one);
        radioButton.setText("01:30 при заказе до 01:30");

        radioButton = (RadioButton) findViewById(R.id.radio_2_two);
        radioButton.setText("01:45");

        radioButton = (RadioButton) findViewById(R.id.radio_3_three);
        radioButton.setText("Дыбенко - Мурманское Шоссе, д. 63");

        radioButton = (RadioButton) findViewById(R.id.radio_4_for);
        radioButton.setText("Литейный - Литейный, д. 352");

        radioButton = (RadioButton) findViewById(R.id.radio_5_five);
        radioButton.setText("Ленинский - Бульвар Новаторов, д. 10");


//        listView = (ListView) findViewById(R.id.listViewBasket);

        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasket("Bearer ccec704dc2854ace9141a609174cf92a");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {
//                    priceCount = (ArrayList<BasketPosition>) response.body().getBasketPositions();

                    rest_id = response.body().getClient().getRestaurantId().toString();
                    Toast.makeText(InHouseActivity.this, "SUCCESS: "+rest_id, Toast.LENGTH_LONG).show();


//                    adapter = new InHouseAdapter(InHouseActivity.this, priceCount);
//                    listView.setAdapter(adapter);
                } else {
                    Toast.makeText(InHouseActivity.this, "NOT SUCCESS: "+rest_id, Toast.LENGTH_LONG).show();
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
