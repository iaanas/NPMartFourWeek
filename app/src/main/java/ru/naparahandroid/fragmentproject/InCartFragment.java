package ru.naparahandroid.fragmentproject;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
import ru.naparahandroid.fragmentproject.BasketModel.BasketPosition;
import ru.naparahandroid.fragmentproject.BasketModel.GenBasket;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class InCartFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private OnListFragmentInteractionListener mListener;

    private ArrayList<BasketPosition> priceCount;

    private ListView listView;

    private BasketDataAdapter adapter;

    //    private Button incButton;
//
//    private TextView decText;
//
//    private static Integer basketPosition;

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
            // TODO: Customize parameters
            int mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_incart_list_two, container, false);
        View view2 = inflater.inflate(R.layout.basket_row, container, false);

        priceCount = new ArrayList<>();

        View parentView = view.findViewById(R.id.parentLayoutBasket);

        listView = view.findViewById(R.id.listViewBasket);

//        decButton = (ImageButton) view2.findViewById(R.id.bask_min);

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();


        ApiService api = RetrofitClient.getApiService();
        Call<GenBasket> call = api.getMyBasket(accessToken);
        call.enqueue(new Callback<GenBasket>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
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

            @ParametersAreNonnullByDefault
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
    }

    private void decButton(Integer basketPosition2) {

        ApiService api = RetrofitClient.getApiService();

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();

        Call<GenBasket> call = api.decReaseButton(accessToken, basketPosition2, "decrease_quantity");
        call.enqueue(new Callback<GenBasket>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(InCartFragment.this.getActivity(), "DECREASE!!!"+basketPosition2, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(InCartFragment.this.getActivity(), "NOT SUCCESS!!!"+basketPosition2, Toast.LENGTH_LONG).show();
                }
            }

            @ParametersAreNonnullByDefault
            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {
//                Toast.makeText(InCartFragment.this.getActivity(), "ERROR!!!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void incButton(Integer basketPosition2) {

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();

        ApiService api = RetrofitClient.getApiService();

        Call<GenBasket> call = api.decReaseButton(accessToken, basketPosition2, "increase_quantity");
        call.enqueue(new Callback<GenBasket>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(InCartFragment.this.getActivity(), "INCREASE!!!"+basketPosition2, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(InCartFragment.this.getActivity(), "NOT SUCCESS!!!"+basketPosition2, Toast.LENGTH_LONG).show();
                }
            }

            @ParametersAreNonnullByDefault
            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {
//                Toast.makeText(InCartFragment.this.getActivity(), "ERROR!!!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void deleteForeve(Integer basketPosition) {
        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();

        ApiService api = RetrofitClient.getApiService();

        Call<GenBasket> call = api.decReaseButton(accessToken, basketPosition, "delete");
        call.enqueue(new Callback<GenBasket>() {
            @ParametersAreNonnullByDefault
            @Override
            public void onResponse(Call<GenBasket> call, Response<GenBasket> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(InCartFragment.this.getActivity(), "DELETE FOREVER!!!"+basketPosition, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(InCartFragment.this.getActivity(), "NOT SUCCESS!!!"+basketPosition, Toast.LENGTH_LONG).show();
                }
            }

            @ParametersAreNonnullByDefault
            @Override
            public void onFailure(Call<GenBasket> call, Throwable t) {
//                Toast.makeText(InCartFragment.this.getActivity(), "ERROR!!!", Toast.LENGTH_LONG).show();
            }
        });
    }



    private void restartInCartFragment() {
        assert getFragmentManager() != null;
        InCartFragment fragment = (InCartFragment) getFragmentManager().findFragmentById(R.id.frame_layout_bo);

        assert fragment != null;
        getFragmentManager().beginTransaction()
                .detach(fragment)
                .attach(fragment)
                .commit();
    }

    private void restartInCartTotalFragment() {
        assert getFragmentManager() != null;
        TotalBasketFragment fragment = (TotalBasketFragment) getFragmentManager().findFragmentById(R.id.frame_layout_total);

        assert fragment != null;
        getFragmentManager().beginTransaction()
                .detach(fragment)
                .attach(fragment)
                .commit();
    }


    public class BasketDataAdapter extends ArrayAdapter<BasketPosition> {

        final List<BasketPosition> list;

        final Context context;
        private final LayoutInflater inflater;


        BasketDataAdapter(Context context, List<BasketPosition> objects) {
            super(context, 0, objects);

            this.context = context;
            this.inflater = LayoutInflater.from(context);
            list = objects;
        }

        @Override
        public BasketPosition getItem(int position) {
            return list.get(position);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder vh;

            if(convertView == null) {
                View view = inflater.inflate(R.layout.basket_row, parent, false);
                vh = ViewHolder.create((RelativeLayout) view);
                view.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            BasketPosition item = getItem(position);

            assert item != null;
            vh.name_of_position.setText(item.getPosition().getName());
            vh.quantity.setText(String.valueOf(item.getQuantity()));


            ArrayList<String> arr = new ArrayList<>(item.getPosition().getImages());
            for(int i = 0; i<arr.size(); i++) {
                Picasso.with(context).load(item.getPosition().getImages().get(i)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);
            }

            String MONEY_CHOOSE = "РУБ.";
            vh.price_single_item.setText(String.valueOf(item.getPriceSingleItem()) + MONEY_CHOOSE);

            String TOTAL_SUM = "Итого: ";
            vh.price_total.setText(TOTAL_SUM +String.valueOf(item.getPriceTotal()));


            vh.decButton.setOnClickListener(v -> {
                if(item.getQuantity() == 1) {
                    Toast.makeText(context, "ITS LOST", Toast.LENGTH_LONG).show();
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context, AlertDialog.THEME_HOLO_LIGHT);
                            builder.setTitle("Последний продукт в корзине")
                            .setMessage("Вы действитеотно хотите его удалить из корзины?")
                            .setNegativeButton("Нет, оставить",
                                    (dialog, which) -> dialog.cancel())
                            .setPositiveButton("Да, удалить", (dialog, which) -> {
                                decButton(item.getId());
                                restartInCartFragment();
                                restartInCartTotalFragment();
                            });
                            builder.show();

                } else {
                    decButton(item.getId());
                    restartInCartFragment();
                    restartInCartTotalFragment();
                }

            });

            vh.incButton.setOnClickListener(v -> {
                incButton(item.getId());
                restartInCartFragment();
                restartInCartTotalFragment();
            });


            vh.deleteForeve.setOnClickListener(v -> {
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context, AlertDialog.THEME_HOLO_LIGHT);
                builder.setTitle("Действительно удалить?")
                        .setMessage("Подтверждение удаления блюда")
                        .setNegativeButton("Нет, оставить",
                                (dialog, which) -> dialog.cancel())
                        .setPositiveButton("Да, удалить", (dialog, which) -> {
                            deleteForeve(item.getId());
                            restartInCartFragment();
                            restartInCartTotalFragment();
                        });
                builder.show();
            });

            return vh.rootView;


        }

    }
    private static class ViewHolder {

        final RelativeLayout rootView;
        final ImageView imageView;
        final TextView quantity;
        final TextView price_single_item;
        final TextView price_sub_items;
        final TextView price_total;
        final TextView name_of_position;

        final ImageButton decButton;

        final ImageButton incButton;

        final ImageButton deleteForeve;

        private ViewHolder(RelativeLayout rootView, ImageView imageView,
                           TextView quantity, TextView price_single_item,
                           TextView price_sub_items, TextView price_total,
                           TextView name_of_position, ImageButton decButton, ImageButton incButton, ImageButton deleteForeve) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.quantity = quantity;
            this.price_single_item = price_single_item;
            this.price_sub_items = price_sub_items;
            this.price_total = price_total;
            this.name_of_position = name_of_position;
            this.decButton = decButton;
            this.incButton = incButton;
            this.deleteForeve = deleteForeve;
        }

        static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = rootView.findViewById(R.id.bask_image);
            TextView quantity = rootView.findViewById(R.id.bask_count);
            TextView price_single_item = rootView.findViewById(R.id.bask_cost_item);
            TextView price_sub_items = rootView.findViewById(R.id.bask_subItems);
            TextView price_total = rootView.findViewById(R.id.bask_cost_total);
            TextView name_of_position = rootView.findViewById(R.id.bask_name);

            ImageButton decButton = rootView.findViewById(R.id.bask_min);

            ImageButton incButton = rootView.findViewById(R.id.back_max);

            ImageButton deleteForeve = rootView.findViewById(R.id.del_pos_total);

            return new ViewHolder(rootView, imageView, quantity, price_single_item,
                    price_sub_items, price_total, name_of_position, decButton, incButton, deleteForeve);
        }

    }


}
