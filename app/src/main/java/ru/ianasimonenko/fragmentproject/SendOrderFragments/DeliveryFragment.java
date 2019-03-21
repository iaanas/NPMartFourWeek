package ru.ianasimonenko.fragmentproject.SendOrderFragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.ApiService;
import ru.ianasimonenko.fragmentproject.BasketModel.Address;
import ru.ianasimonenko.fragmentproject.BasketModel.DeliveryTime;
import ru.ianasimonenko.fragmentproject.BasketModel.Example;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;
import ru.ianasimonenko.fragmentproject.InBasketOrdersActivity;
import ru.ianasimonenko.fragmentproject.LoginActivity;
import ru.ianasimonenko.fragmentproject.R;
import ru.ianasimonenko.fragmentproject.RetrofitClient;
import ru.ianasimonenko.fragmentproject.SendOrderFragments.dummy.DummyContent.DummyItem;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Nullable;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class DeliveryFragment extends Fragment {
    private View parentView;

    private Integer rest_id;
    private String choosePay;

    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox checkBox;

    private Spinner spinnerTime;
    private Spinner spinnerPeoples;

    private Button sendOrder;
    private String selected;
    private String selected2;
    private String clientsideId;

    private EditText street;
    private EditText corp;
    private EditText house;
    private EditText flat;

//    private String streetStr;
//    private String corpStr;
//    private String houseStr;
//    private String flatStr;

    Address address;

    private EditText commentView;
    private Boolean checked;
    private String accessToken;

    private ArrayList<DeliveryTime> priceCount;
    DeliveryDataAdapter adapter;

    private String addressString;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DeliveryFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static DeliveryFragment newInstance(int columnCount) {
        DeliveryFragment fragment = new DeliveryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_with_delivery, container, false);

        //View
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroupPayment);

        radioButton = (RadioButton) view.findViewById(R.id.radio_cash);
        radioButton.setText("Наличные");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = (RadioButton) view.findViewById(R.id.radio_cashless);
        radioButton.setText("Карта");
        radioButton.setOnClickListener(radioButtonClickListener);


        checkBox = (CheckBox) view.findViewById(R.id.checkBox);
        checked = checkBox.isChecked();

        //Spinner
        spinnerTime = (Spinner) view.findViewById(R.id.spinner_time);
        spinnerPeoples = (Spinner) view.findViewById(R.id.spinner_peoples);
        selected2 = spinnerPeoples.getSelectedItem().toString();

        //Views
        commentView = (EditText) view.findViewById(R.id.comment);
        String comment = commentView.getText().toString();

        sendOrder = (Button) view.findViewById(R.id.send_orders);

        //Address
        street = (EditText) view.findViewById(R.id.street);
        corp = (EditText) view.findViewById(R.id.corp);
        house = (EditText) view.findViewById(R.id.house);
        flat = (EditText) view.findViewById(R.id.flat);

        address = new Address("Санкт-Петербург", corp.getText().toString(),
                flat.getText().toString(), house.getText().toString(), street.getText().toString());

        addressString = "?grant_type=" + "address"+ "&city="+"Санкт-петербург"+"&corp="+corp.getText().toString()+
                "&flat="+flat.getText().toString()+"&house="+house.getText().toString()+"&street="+street.getText().toString();




        LoginActivity activity = new LoginActivity();
        Toast.makeText(inflater.getContext(), "TOKEN: "+ activity.getMyTokenFromLogin(), Toast.LENGTH_LONG).show();

        accessToken = activity.getMyTokenFromLogin();

        // Set the adapter
        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasket(accessToken);
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {

                    priceCount = (ArrayList<DeliveryTime>) response.body().getDeliveryTimes();
                    adapter = new DeliveryDataAdapter(inflater.getContext(), priceCount);
                    spinnerTime.setAdapter(adapter);


                    spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selected = spinnerTime.getSelectedItem().toString().replaceAll(":", "");
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                    Toast.makeText(inflater.getContext(), "SUCCESS: "+selected, Toast.LENGTH_LONG).show();


                    Toast.makeText(inflater.getContext(), "SUCCESS: ", Toast.LENGTH_LONG).show();

                    sendOrder.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sendOrder(selected, comment, selected2, checked);
                        }
                    });

                } else {
                    Toast.makeText(inflater.getContext(), "NOT SUCCESS"+selected, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {
                Toast.makeText(inflater.getContext(), "ERROR: "+rest_id, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radio_cash:
                    choosePay = "cash";
                    break;
                case R.id.radio_cashless:
                    choosePay = "cashless";
                    break;
            }
        }
    };

    public void sendOrder(String selected, String comment, String selected2, Boolean checked) {
        Integer rest_id_total = rest_id;
        String payment = choosePay;

        String clientId = UUID.randomUUID().toString();
        String clientIdClean = clientId.replaceAll("-", "");

        clientsideId = clientIdClean.substring(0, 16);

        Address address = new Address("Санкт-Петербург", street.getText().toString(), house.getText().toString(),
                corp.getText().toString(), flat.getText().toString());

        Example example = new Example(address, selected, null, clientsideId+"", comment, "False", "cash", selected2, "delivery",
                true, rest_id_total, "False");



        ApiService api = RetrofitClient.getApiService();

        Call<Example> call = api.postOrderDelivery(accessToken, example);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(DeliveryFragment.this.getContext(), "SUCCESS: "+ example, Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder builder = new AlertDialog.Builder(DeliveryFragment.this.getContext(), AlertDialog.THEME_HOLO_LIGHT);
                    builder.setTitle("Заказ успешно отправлен!")
                            .setMessage("Скоро с Вами свяжется нам менеджер для подтверждения деталей заказа.")
                            .setCancelable(false)
                            .setNegativeButton("Ок, жду звонка", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(DeliveryFragment.this.getContext(), InBasketOrdersActivity.class);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                } else {
                    Toast.makeText(DeliveryFragment.this.getContext(), "NOT SUCCESS: "+ example, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(DeliveryFragment.this.getContext(), "ERROR: "+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }

    public class DeliveryDataAdapter extends ArrayAdapter<DeliveryTime> {

        List<DeliveryTime> list;

        Context context;
        private LayoutInflater inflater;


        public DeliveryDataAdapter(Context context, List<DeliveryTime> objects) {
            super(context, R.layout.spinner_row_delivery, objects);

            this.context = context;
            this.inflater = LayoutInflater.from(context);
            list = objects;
        }

        @Override
        public DeliveryTime getItem(int position) {
            return list.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder vh;

            if(convertView == null) {
                View view = inflater.inflate(R.layout.spinner_row_delivery, parent, false);
                vh = (ViewHolder) ViewHolder.create((TextView) view);
                view.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            DeliveryTime item = getItem(position);
            final String timeOfName = item.getName();


            vh.selectedTime.setText(timeOfName);


            return vh.rootView;


        }

    }
    private static class ViewHolder {

        public final TextView rootView;
        public final TextView selectedTime;

        private ViewHolder(TextView rootView, TextView selectedTime) {
            this.rootView = rootView;
            this.selectedTime = selectedTime;
        }

        public static ViewHolder create(TextView rootView) {
            TextView selectedTime = (TextView) rootView.findViewById(R.id.time_spinner);

            return new ViewHolder(rootView, selectedTime);
        }

    }
}
