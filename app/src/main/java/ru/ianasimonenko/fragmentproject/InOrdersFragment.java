package ru.ianasimonenko.fragmentproject;

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
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.OrdersModel.GenOrders;
import ru.ianasimonenko.fragmentproject.OrdersModel.Order;
import ru.ianasimonenko.fragmentproject.dummy.DummyContent;
import ru.ianasimonenko.fragmentproject.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class InOrdersFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    private ArrayList<Order> priceCount;

    private View parentView;
    private ListView listView;

    private OrdersDataAdapter adapter;

    private Button addOrderAgain;

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
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_orders, container, false);

        // Set the adapter
        priceCount = new ArrayList<>();

        parentView = view.findViewById(R.id.parentLayoutOrders);

        listView = (ListView) view.findViewById(R.id.listViewOrders);

        addOrderAgain = (Button) view.findViewById(R.id.button_add_in_orders);

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();



        ApiService api = RetrofitClient.getApiService();
        Call<GenOrders> call = api.getOrders(accessToken, "get");
        call.enqueue(new Callback<GenOrders>() {
            @Override
            public void onResponse(Call<GenOrders> call, Response<GenOrders> response) {
                if (response.isSuccessful()) {
                    priceCount = (ArrayList<Order>) response.body().getOrders();

                    adapter = new OrdersDataAdapter(inflater.getContext(), priceCount);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<GenOrders> call, Throwable t) {

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
        // TODO: Update argument type and name
        void onListFragmentInteraction(OrdersDataAdapter item);
    }
}
