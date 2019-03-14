package ru.ianasimonenko.fragmentproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class InCartFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    private ArrayList<BasketPosition> priceCount;

    private View parentView;
    private ListView listView;

    private BasketDataAdapter adapter;

    private Button incButton;

    private TextView decText;

    private static Integer basketPosition;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InCartFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static InCartFragment newInstance(int columnCount) {
        InCartFragment fragment = new InCartFragment();
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

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_incart_list2, container, false);
        View view2 = inflater.inflate(R.layout.basket_row, container, false);

        priceCount = new ArrayList<>();

        parentView = view.findViewById(R.id.parentLayoutBasket);

        listView = (ListView) view.findViewById(R.id.listViewBasket);

//        decButton = (ImageButton) view2.findViewById(R.id.bask_min);


        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasket("Bearer ccec704dc2854ace9141a609174cf92a");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {
                    priceCount = (ArrayList<BasketPosition>) response.body().getBasketPositions();

                    adapter = new BasketDataAdapter(inflater.getContext(), priceCount);
                    listView.setAdapter(adapter);



//                    decButton.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Call<GenBasket> call = api.decReaseButton("Bearer ccec704dc2854ace9141a609174cf92a", response.body().getBasketPositions().get(3).getId(), "decrease_quantity");
//                            call.enqueue(new Callback<GenBasket>() {
//                                @Override
//                                public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
//                                    if(response.isSuccessful()) {
//                                        Toast.makeText(InCartFragment.this.getActivity(), "DECREASE!!!", Toast.LENGTH_LONG).show();
//                                    } else {
//                                        Toast.makeText(InCartFragment.this.getActivity(), "NOT!!!", Toast.LENGTH_LONG).show();
//                                    }
//                                }
//
//                                @Override
//                                public void onFailure(Call<GenBasket> call, Throwable t) {
//                                    Toast.makeText(InCartFragment.this.getActivity(), "ERROR!!!", Toast.LENGTH_LONG).show();
//                                }
//                            });
//                        }
//                    });



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
        void onListFragmentInteraction(BasketDataAdapter item);
    }

    public void decButton(Integer basketPosition2) {

        ApiService api = RetrofitClient.getApiService();

        Call<GenBasket> call = api.decReaseButton("Bearer ccec704dc2854ace9141a609174cf92a", basketPosition2, "decrease_quantity");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(InCartFragment.this.getActivity(), "DECREASE!!!"+basketPosition2, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(InCartFragment.this.getActivity(), "NOT SUCCESS!!!"+basketPosition2, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {
//                Toast.makeText(InCartFragment.this.getActivity(), "ERROR!!!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void incButton(Integer basketPosition2) {

        ApiService api = RetrofitClient.getApiService();

        Call<GenBasket> call = api.decReaseButton("Bearer ccec704dc2854ace9141a609174cf92a", basketPosition2, "increase_quantity");
        call.enqueue(new Callback<GenBasket>() {
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(InCartFragment.this.getActivity(), "INCREASE!!!"+basketPosition2, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(InCartFragment.this.getActivity(), "NOT SUCCESS!!!"+basketPosition2, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {
//                Toast.makeText(InCartFragment.this.getActivity(), "ERROR!!!", Toast.LENGTH_LONG).show();
            }
        });

    }



    public void restartInCartFragment() {
        InCartFragment fragment = (InCartFragment) getFragmentManager().findFragmentById(R.id.frame_layout_bo);

        getFragmentManager().beginTransaction()
                .detach(fragment)
                .attach(fragment)
                .commit();
    }

    public void restartInCartTotalFragment() {
        TotalBasketFragment fragment = (TotalBasketFragment) getFragmentManager().findFragmentById(R.id.frame_layout_total);

        getFragmentManager().beginTransaction()
                .detach(fragment)
                .attach(fragment)
                .commit();
    }




    public class BasketDataAdapter extends ArrayAdapter<BasketPosition> {

        List<BasketPosition> list;

        Context context;
        private LayoutInflater inflater;


        public BasketDataAdapter(Context context, List<BasketPosition> objects) {
            super(context, 0, objects);

            this.context = context;
            this.inflater = LayoutInflater.from(context);
            list = objects;
        }

        @Override
        public BasketPosition getItem(int position) {
            return list.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder vh;

            if(convertView == null) {
                View view = inflater.inflate(R.layout.basket_row, parent, false);
                vh = (ViewHolder) ViewHolder.create((RelativeLayout) view);
                view.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            BasketPosition item = getItem(position);

            vh.name_of_position.setText(item.getPosition().getName());
            vh.quantity.setText(item.getQuantity().toString());

            ArrayList<String> arr = new ArrayList<>();
            arr.addAll(item.getPosition().getImages());
            for(int i = 0; i<arr.size(); i++) {
                Picasso.with(context).load(item.getPosition().getImages().get(i)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);
            }

            vh.price_single_item.setText(item.getPriceSingleItem().toString() + "РУБ.");

            vh.price_total.setText("Итого: "+item.getPriceTotal().toString());

            vh.decButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    decButton(item.getId());
                    restartInCartFragment();
                    restartInCartTotalFragment();
                }
            });

            vh.incButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    incButton(item.getId());
                    restartInCartFragment();
                    restartInCartTotalFragment();
                }
            });

            return vh.rootView;


        }

    }
    private static class ViewHolder {

        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView quantity;
        public final TextView price_single_item;
        public final TextView price_sub_items;
        public final TextView price_total;
        public final TextView name_of_position;

        public final ImageButton decButton;

        public final ImageButton incButton;

        private ViewHolder(RelativeLayout rootView, ImageView imageView,
                           TextView quantity, TextView price_single_item,
                           TextView price_sub_items, TextView price_total,
                           TextView name_of_position, ImageButton decButton, ImageButton incButton) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.quantity = quantity;
            this.price_single_item = price_single_item;
            this.price_sub_items = price_sub_items;
            this.price_total = price_total;
            this.name_of_position = name_of_position;
            this.decButton = decButton;
            this.incButton = incButton;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.bask_image);
            TextView quantity = (TextView) rootView.findViewById(R.id.bask_count);
            TextView price_single_item = (TextView) rootView.findViewById(R.id.bask_cost_item);
            TextView price_sub_items = (TextView) rootView.findViewById(R.id.bask_subItems);
            TextView price_total = (TextView) rootView.findViewById(R.id.bask_cost_total);
            TextView name_of_position = (TextView) rootView.findViewById(R.id.bask_name);

            ImageButton decButton = (ImageButton) rootView.findViewById(R.id.bask_min);

            ImageButton incButton = (ImageButton) rootView.findViewById(R.id.back_max);

            return new ViewHolder(rootView, imageView, quantity, price_single_item,
                    price_sub_items, price_total, name_of_position, decButton, incButton);
        }

    }


}
