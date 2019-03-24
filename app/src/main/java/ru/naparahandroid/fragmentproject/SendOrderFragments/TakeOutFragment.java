package ru.naparahandroid.fragmentproject.SendOrderFragments;

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
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.naparahandroid.fragmentproject.ApiService;
import ru.naparahandroid.fragmentproject.BasketModel.DeliveryTime;
import ru.naparahandroid.fragmentproject.BasketModel.GenBasket;
import ru.naparahandroid.fragmentproject.InBasketOrdersActivity;
import ru.naparahandroid.fragmentproject.LoginActivity;
import ru.naparahandroid.fragmentproject.R;
import ru.naparahandroid.fragmentproject.RetrofitClient;
import ru.naparahandroid.fragmentproject.SendOrderFragments.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TakeOutFragment extends Fragment {

    private ArrayList<DeliveryTime> priceCount;

    private ListView listView;

    private Integer rest_id;

    private Spinner spinnerTime;
    private TextView selectionSpinner;

    private Button sendOrder;
    private String selected;
    private String selected2;

    private Integer peoples;
    private Boolean checked;
    private String accessToken;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private OnListFragmentInteractionListener mListener;

    private TakeOutDataAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TakeOutFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TakeOutFragment newInstance(int columnCount) {
        TakeOutFragment fragment = new TakeOutFragment();
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
        View view = inflater.inflate(R.layout.activity_take_out, container, false);


        // Set the adapter
        priceCount = new ArrayList<>();
        View parentView = view.findViewById(R.id.parentLayoutBasket);

        //View
        RadioGroup radioGroup = view.findViewById(R.id.radio_group);
        RadioButton radioButton = view.findViewById(R.id.radio_one);
        radioButton.setText("В. О. - 7-я линия В.О., д. 63");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_two);
        radioButton.setText("Марата - Марата, 69-71");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_three);
        radioButton.setText("Спортивная - Большой проспект, д. 49");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_for);
        radioButton.setText("Дыбенко - Мурманское Шоссе, д. 63");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_five);
        radioButton.setText("Литейный - Литейный, д. 352");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_six);
        radioButton.setText("Ленинский - Бульвар Новаторов, д. 10");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_seven);
        radioButton.setText("Пионерская - Коломяжский проспект, 15А");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = view.findViewById(R.id.radio_eight);
        radioButton.setText("Гостиный - Садовая улица, д. 55");
        radioButton.setOnClickListener(radioButtonClickListener);

        CheckBox checkBox = view.findViewById(R.id.checkBox);
        checked = checkBox.isChecked();


        //Spinner

        spinnerTime = view.findViewById(R.id.spinner_time);
        selected = spinnerTime.getSelectedItem().toString();

        Spinner spinnerPeoples = view.findViewById(R.id.spinner_peoples);
        selected2 = spinnerPeoples.getSelectedItem().toString();

        ArrayList<DeliveryTime> list = new ArrayList<>();

        //Views
        EditText commentView = view.findViewById(R.id.comment);
        String comment = commentView.getText().toString();

        sendOrder = view.findViewById(R.id.send_orders);


        LoginActivity activity = new LoginActivity();
        Toast.makeText(inflater.getContext(), "TOKEN: "+ activity.getMyTokenFromLogin(), Toast.LENGTH_LONG).show();

        accessToken = activity.getMyTokenFromLogin();

        // Set the adapter
        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasket(accessToken);
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(@NonNull Call<GenBasket> call, @NonNull Response<GenBasket> response) {
                if (response.isSuccessful()) {

                    priceCount = (ArrayList<DeliveryTime>) Objects.requireNonNull(response.body()).getDeliveryTimes();
                    adapter = new TakeOutDataAdapter(inflater.getContext(), priceCount);
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

                    sendOrder.setOnClickListener(v -> sendOrder(selected, comment, selected2, checked));

                } else {
                    Toast.makeText(inflater.getContext(), "NOT SUCCESS"+rest_id, Toast.LENGTH_LONG).show();
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
                clientsideId +"", comment, "False", "cash", selected2, "takeaway",
                true, rest_id_total, "False");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(@NonNull Call<GenBasket> call, @NonNull Response<GenBasket> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(TakeOutFragment.this.getContext(), "SUCCESS"+rest_id_total, Toast.LENGTH_LONG).show();

                    AlertDialog.Builder builder = new AlertDialog.Builder(TakeOutFragment.this.getContext(), AlertDialog.THEME_HOLO_LIGHT);
                    builder.setTitle("Заказ успешно отправлен!")
                            .setMessage("Скоро с Вами свяжется нам менеджер для подтверждения деталей заказа.")
                            .setCancelable(false)
                            .setNegativeButton("Ок, жду звонка", (dialog, which) -> {
                                Intent intent = new Intent(TakeOutFragment.this.getContext(), InBasketOrdersActivity.class);
                                startActivity(intent);
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                } else {
                    Toast.makeText(TakeOutFragment.this.getContext(), "NOT SUCCESS: "+rest_id_total, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GenBasket> call, @NonNull Throwable t) {
                Toast.makeText(TakeOutFragment.this.getContext(), "ERROR: "+rest_id, Toast.LENGTH_LONG).show();
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



    class TakeOutDataAdapter extends ArrayAdapter<DeliveryTime> {

        final List<DeliveryTime> list;

        final Context context;
        private final LayoutInflater inflater;


        TakeOutDataAdapter(Context context, List<DeliveryTime> objects) {
            super(context, R.layout.spinner_row_take_out, objects);

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
                View view = inflater.inflate(R.layout.spinner_row_take_out, parent, false);
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
