package ru.ianasimonenko.fragmentproject.SendOrderFragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.ApiService;
import ru.ianasimonenko.fragmentproject.BasketModel.DeliveryTime;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;
import ru.ianasimonenko.fragmentproject.InBasketOrdersActivity;
import ru.ianasimonenko.fragmentproject.LoginActivity;
import ru.ianasimonenko.fragmentproject.R;
import ru.ianasimonenko.fragmentproject.RetrofitClient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class InHouseFragment extends Fragment {

    private Integer rest_id;

    private Spinner spinnerTime;

    private Button sendOrder;
    private Object selected;
    private String selected2;

    private Boolean checked;
    private String accessToken;

    private ArrayList<DeliveryTime> priceCount;
    private InHouseDataAdapter adapter;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InHouseFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static InHouseFragment newInstance(int columnCount) {
        InHouseFragment fragment = new InHouseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            // TODO: Customize parameters
            int mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_in_house, container, false);

//        listView = (ListView) view.findViewById(R.id.list_time);

        priceCount = new ArrayList<>();
        View parentView = view.findViewById(R.id.activity_in_house);

        //View
        RadioGroup radioGroup = view.findViewById(R.id.radio_group);
        RadioButton radioButton = view.findViewById(R.id.radio_one);
        String BUTTON_ONE = "В. О. - 7-я линия В.О., д. 63";
        radioButton.setText(BUTTON_ONE);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_two);
        String BUTTON_TWO = "Марата - Марата, 69-71";
        radioButton.setText(BUTTON_TWO);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_three);
        String BUTTON_THREE = "Спортивная - Большой проспект, д. 49";
        radioButton.setText(BUTTON_THREE);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_for);
        String BUTTON_FOUR = "Дыбенко - Мурманское Шоссе, д. 63";
        radioButton.setText(BUTTON_FOUR);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_five);
        String BUTTON_FIVE = "Литейный - Литейный, д. 352";
        radioButton.setText(BUTTON_FIVE);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_six);
        String BUTTON_SIX = "Ленинский - Бульвар Новаторов, д. 10";
        radioButton.setText(BUTTON_SIX);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_seven);
        String BUTTON_SEVEN = "Пионерская - Коломяжский проспект, 15А";
        radioButton.setText(BUTTON_SEVEN);
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_eight);
        String BUTTON_EIGHT = "Гостиный - Садовая улица, д. 55";
        radioButton.setText(BUTTON_EIGHT);
        radioButton.setOnClickListener(radioButtonClickListener);

        CheckBox checkBox = view.findViewById(R.id.checkBox);
        checked = checkBox.isChecked();

        //Spinner
        spinnerTime = view.findViewById(R.id.spinner_time);
        Spinner spinnerPeoples = view.findViewById(R.id.spinner_peoples);
        selected2 = spinnerPeoples.getSelectedItem().toString();

        //Views
        EditText commentView = view.findViewById(R.id.comment);
        String comment = commentView.getText().toString();

        sendOrder = view.findViewById(R.id.send_orders);


        LoginActivity activity = new LoginActivity();
        Toast.makeText(inflater.getContext(), "TOKEN: "+ activity.getMyTokenFromLogin(), Toast.LENGTH_LONG).show();

        accessToken = activity.getMyTokenFromLogin();

        // Set the adapter
        final ApiService[] api = {RetrofitClient.getApiService()};
        Call<GenBasket> call = api[0].getMyBasket(accessToken);
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(@NonNull Call<GenBasket> call, @NonNull Response<GenBasket> response) {
                if (response.isSuccessful()) {

                    assert response.body() != null;
                    priceCount = (ArrayList<DeliveryTime>) response.body().getDeliveryTimes();
                    adapter = new InHouseDataAdapter(inflater.getContext(), priceCount);
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

                    sendOrder.setOnClickListener(v -> sendOrder(selected.toString(), comment, selected2, checked));

                } else {
                    Toast.makeText(inflater.getContext(), "NOT SUCCESS"+selected.toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GenBasket> call, @NonNull Throwable t) {
                Toast.makeText(inflater.getContext(), "ERROR: "+rest_id, Toast.LENGTH_LONG).show();
            }
        });
        return view;
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
                    rest_id = 15;
                    break;
                case R.id.radio_three:
                    rest_id = 14;
                    break;
                case R.id.radio_for:
                    rest_id = 12;
                case R.id.radio_five:
                    rest_id = 16;
                    break;
                case R.id.radio_six:
                    rest_id = 11;
                    break;
                case R.id.radio_seven:
                    rest_id = 10;
                    break;
                case R.id.radio_eight:
                    rest_id = 9;
                    break;
            }
        }
    };

    private void sendOrder(String selected, String comment, String selected2, Boolean checked) {
        Integer rest_id_total = rest_id;

        String clientId = UUID.randomUUID().toString();
        String clientIdClean = clientId.replaceAll("-", "");

        String clientsideId = clientIdClean.substring(0, 16);


        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.postOrderInRest(accessToken, selected, null,
                clientsideId +"", comment, "False", "cash", selected2, "stay",
                true, rest_id_total, "False");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(@NonNull Call<GenBasket> call, @NonNull Response<GenBasket> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(InHouseFragment.this.getContext(), "SUCCESS", Toast.LENGTH_LONG).show();

                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(InHouseFragment.this.getContext(), android.app.AlertDialog.THEME_HOLO_LIGHT);
                    builder.setTitle("Заказ успешно отправлен!")
                            .setMessage("Скоро с Вами свяжется нам менеджер для подтверждения деталей заказа.")
                            .setCancelable(false)
                            .setNegativeButton("Ок, жду звонка", (dialog, which) -> {
                                Intent intent = new Intent(InHouseFragment.this.getContext(), InBasketOrdersActivity.class);
                                startActivity(intent);
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                } else {
                    Toast.makeText(InHouseFragment.this.getContext(), "NOT SUCCESS: "+selected, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GenBasket> call, @NonNull Throwable t) {
                Toast.makeText(InHouseFragment.this.getContext(), "ERROR: "+rest_id, Toast.LENGTH_LONG).show();
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
        void onListFragmentInteraction();
    }

    class InHouseDataAdapter extends ArrayAdapter<DeliveryTime> {

        final List<DeliveryTime> list;

        final Context context;
        private final LayoutInflater inflater;


        InHouseDataAdapter(Context context, List<DeliveryTime> objects) {
            super(context, R.layout.spinner_row, objects);

            this.context = context;
            this.inflater = LayoutInflater.from(context);
            list = objects;
        }

        @Override
        public DeliveryTime getItem(int position) {
            return list.get(position);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            final ViewHolder vh;

            if(convertView == null) {
                View view = inflater.inflate(R.layout.spinner_row, parent, false);
                vh = ViewHolder.create((TextView) view);
                view.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            DeliveryTime item = getItem(position);
            assert item != null;
            final String timeOfName = item.getName();


            vh.selectedTime.setText(timeOfName);


            return vh.rootView;


        }

    }
    private static class ViewHolder {

        final TextView rootView;
        final TextView selectedTime;

        private ViewHolder(TextView rootView, TextView selectedTime) {
            this.rootView = rootView;
            this.selectedTime = selectedTime;
        }

        static ViewHolder create(TextView rootView) {
            TextView selectedTime = rootView.findViewById(R.id.time_spinner);

            return new ViewHolder(rootView, selectedTime);
        }

    }



}
