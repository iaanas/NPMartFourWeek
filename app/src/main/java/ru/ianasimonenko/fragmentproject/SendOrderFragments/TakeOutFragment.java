package ru.ianasimonenko.fragmentproject.SendOrderFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import ru.ianasimonenko.fragmentproject.ApiService;
import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.BasketModel.DeliveryTime;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;
import ru.ianasimonenko.fragmentproject.LoginActivity;
import ru.ianasimonenko.fragmentproject.R;
import ru.ianasimonenko.fragmentproject.RetrofitClient;
import ru.ianasimonenko.fragmentproject.SendOrderFragments.dummy.DummyContent;
import ru.ianasimonenko.fragmentproject.SendOrderFragments.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TakeOutFragment extends Fragment {

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

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

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
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_take_out, container, false);

        // Set the adapter
        priceCount = new ArrayList<>();
        parentView = view.findViewById(R.id.parentLayoutBasket);

        //View
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        radioButton = (RadioButton) view.findViewById(R.id.radio_one);
        radioButton.setText("В. О. - 7-я линия В.О., д. 63");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = (RadioButton) view.findViewById(R.id.radio_two);
        radioButton.setText("Марата - Марата, 69-71");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = (RadioButton) view.findViewById(R.id.radio_three);
        radioButton.setText("Спортивная - Большой проспект, д. 49");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = (RadioButton) view.findViewById(R.id.radio_for);
        radioButton.setText("Дыбенко - Мурманское Шоссе, д. 63");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = (RadioButton) view.findViewById(R.id.radio_five);
        radioButton.setText("Литейный - Литейный, д. 352");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = (RadioButton) view.findViewById(R.id.radio_six);
        radioButton.setText("Ленинский - Бульвар Новаторов, д. 10");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = (RadioButton) view.findViewById(R.id.radio_seven);
        radioButton.setText("Пионерская - Коломяжский проспект, 15А");
        radioButton.setOnClickListener(radioButtonClickListener);

        radioButton = (RadioButton) view.findViewById(R.id.radio_eight);
        radioButton.setText("Гостиный - Садовая улица, д. 55");
        radioButton.setOnClickListener(radioButtonClickListener);

        checkBox = (CheckBox) view.findViewById(R.id.checkBox);
        checked = checkBox.isChecked();


        //Spinner

        spinnerTime = (Spinner) view.findViewById(R.id.spinner_time);
        selected = spinnerTime.getSelectedItem().toString();

        spinnerPeoples = (Spinner) view.findViewById(R.id.spinner_peoples);
        selected2 = spinnerPeoples.getSelectedItem().toString();

        ArrayList<DeliveryTime> list = new ArrayList<>();

        //Views
        commentView = (EditText) view.findViewById(R.id.comment);
        String comment = commentView.getText().toString();

        sendOrder = (Button) view.findViewById(R.id.send_orders);


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

                    list.addAll(response.body().getDeliveryTimes());

//                    ArrayAdapter<DeliveryTime> deliveryTimeArrayAdapter = ArrayAdapter.createFromResource(
//                            inflater.getContext(), list, android.R.layout.simple_spinner_item
//                    );

//                    rest_id = response.body().getClient().getRestaurantId();
                    Toast.makeText(inflater.getContext(), "SUCCESS: ", Toast.LENGTH_LONG).show();

                    sendOrder.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sendOrder(selected, comment, selected2, checked);
                        }
                    });

                } else {
                    Toast.makeText(inflater.getContext(), "NOT SUCCESS"+rest_id, Toast.LENGTH_LONG).show();
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

    public void sendOrder(String selected, String comment, String selected2, Boolean checked) {

        String clientId = UUID.randomUUID().toString();
        String clientIdClean = clientId.replaceAll("-", "");

        clientsideId = clientIdClean.substring(0, 16);


        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.postOrderInRest(accessToken, "2000", null,
                clientsideId+"", comment, "False", "cash", selected2, "takeaway",
                true, 13, "False");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(TakeOutFragment.this.getContext(), "SUCCESS", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(TakeOutFragment.this.getContext(), "NOT SUCCESS: "+clientsideId, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {
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
}
