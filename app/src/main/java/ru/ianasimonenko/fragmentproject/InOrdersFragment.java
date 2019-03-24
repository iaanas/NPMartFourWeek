package ru.ianasimonenko.fragmentproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.OrdersModel.GenOrders;
import ru.ianasimonenko.fragmentproject.OrdersModel.Order;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class InOrdersFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private OnListFragmentInteractionListener mListener;

    private ArrayList<Order> priceCount;

    private ListView listView;

    private OrdersDataAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InOrdersFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static InOrdersFragment newInstance(int columnCount) {
        InOrdersFragment fragment = new InOrdersFragment();
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
        View view = inflater.inflate(R.layout.activity_orders, container, false);

        // Set the adapter
        priceCount = new ArrayList<>();

        View parentView = view.findViewById(R.id.parentLayoutOrders);

        listView = view.findViewById(R.id.listViewOrders);

        Button addOrderAgain = view.findViewById(R.id.button_add_in_orders);

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();



        ApiService api = RetrofitClient.getApiService();
        Call<GenOrders> call = api.getOrders(accessToken, "get");
        call.enqueue(new Callback<GenOrders>() {
            @Override
            public void onResponse(@NonNull Call<GenOrders> call, @NonNull Response<GenOrders> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    priceCount = (ArrayList<Order>) response.body().getOrders();

                    adapter = new OrdersDataAdapter(inflater.getContext(), priceCount);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<GenOrders> call, @NonNull Throwable t) {

            }
        });
        return view;
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
    }
}
