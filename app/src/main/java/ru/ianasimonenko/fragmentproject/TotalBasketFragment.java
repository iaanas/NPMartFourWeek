package ru.ianasimonenko.fragmentproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;
import ru.ianasimonenko.fragmentproject.Model.Menu;
import ru.ianasimonenko.fragmentproject.Model.Restaurant;
import ru.ianasimonenko.fragmentproject.dummy.DummyContent;
import ru.ianasimonenko.fragmentproject.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TotalBasketFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    private ArrayList<GenBasket> priceCount;

    private View parentView;
    private ListView listView;

    private BasketTotalAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TotalBasketFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TotalBasketFragment newInstance(int columnCount) {
        TotalBasketFragment fragment = new TotalBasketFragment();
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
        View view = inflater.inflate(R.layout.fragment_total_basket_list, container, false);

        priceCount = new ArrayList<>();

        parentView = view.findViewById(R.id.parentLayoutBasket);

        listView = (ListView) view.findViewById(R.id.listViewBasketTotal);


        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasket("Bearer ccec704dc2854ace9141a609174cf92a");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {

                    priceCount.add(response.body());

                    adapter = new BasketTotalAdapter(inflater.getContext(), priceCount);
                    listView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {

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
        void onListFragmentInteraction(DummyItem item);
    }


}