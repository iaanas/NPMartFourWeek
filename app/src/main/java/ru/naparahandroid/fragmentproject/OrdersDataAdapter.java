package ru.naparahandroid.fragmentproject;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.naparahandroid.fragmentproject.OrdersModel.GenOrders;
import ru.naparahandroid.fragmentproject.OrdersModel.Order;

class OrdersDataAdapter extends ArrayAdapter<Order> {
    private final List<Order> list;

    private final Context context;
    private final LayoutInflater inflater;

    private OrdersDataAdapterTwo adapter2;

    public OrdersDataAdapter(Context context, List<Order> objects) {
        super(context, 0, objects);

        this.context = context;
        this.inflater = LayoutInflater.from(context);
        list = objects;
    }


    @Override
    public Order getItem(int position) {
        return list.get(position);
    }


    @NonNull
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final ViewHolder vh;

        if(convertView == null) {
            View view = inflater.inflate(R.layout.orders_row, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Order item = getItem(position);

        assert item != null;
        vh.number.setText(item.getNumber());

        vh.date_create.setText(String.valueOf(item.getCreated()));

        vh.restaurant_create.setText(item.getRestaurant().getName());

        vh.status_create.setText(item.getReadableState());

        vh.what_todo_create.setText(item.getReadablePresenceState());

        vh.delivery_create.setText(item.getAddress());

        vh.peoples_create.setText(String.valueOf(item.getPeopleAmount()));

        vh.time_of_delivery_create.setText(String.valueOf(item.getArriving()));

        vh.comment_create.setText(item.getComment());

        vh.total_cost_create.setText(String.valueOf(item.getPriceTotal()));

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();

        vh.addOrderAgain.setOnClickListener(v -> {
            ApiService api = RetrofitClient.getApiService();
            Call<GenOrders> callorderAgain = api.addOrderAgain(accessToken, item.getId(), "add_again");
            callorderAgain.enqueue(new Callback<GenOrders>() {
                @Override
                public void onResponse(@NonNull Call<GenOrders> call, @NonNull Response<GenOrders> response) {
                    if(response.isSuccessful()) {
                        Toast.makeText(context, "SUCCESS "+
                                item.getId(), Toast.LENGTH_SHORT).show();

                        AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_HOLO_LIGHT);
                        builder.setTitle("Заказ в корзине!")
                                .setMessage("Заказ повторно успешно добавлен в корзину.")
                                .setCancelable(false)
                                .setNegativeButton("Ок", (dialog, which) -> {
                                    Intent intent = new Intent(context, InBasketOrdersActivity.class);
                                    context.startActivity(intent);
                                });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    } else {
                        Toast.makeText(context, "NOT SUCCESS "+
                                item.getId(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<GenOrders> call, @NonNull Throwable t) {
                    Toast.makeText(context, "ERROR "+
                            t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });


        return vh.rootView;
    }

    public static class ViewHolder {

        final RelativeLayout rootView;
        final TextView number;
        final TextView date_create;
        final TextView restaurant_create;
        final TextView status_create;
        final TextView what_todo_create;
        final TextView delivery_create;
        final TextView peoples_create;
        final TextView time_of_delivery_create;
        final TextView comment_create;
        final TextView total_cost_create;

        final ListView list_of_products;

        final Button addOrderAgain;

        private ViewHolder(RelativeLayout rootView, TextView number, TextView date_create, TextView restaurant_create, TextView status_create,
                           TextView what_todo_create, TextView delivery_create, TextView peoples_create, TextView time_of_delivery_create,
                           TextView comment_create, TextView total_cost_create, ListView list_of_products, Button addOrderAgain) {
            this.rootView = rootView;
            this.number = number;
            this.date_create = date_create;
            this.restaurant_create = restaurant_create;
            this.status_create = status_create;
            this.what_todo_create = what_todo_create;
            this.delivery_create = delivery_create;
            this.peoples_create = peoples_create;
            this.time_of_delivery_create = time_of_delivery_create;
            this.comment_create = comment_create;
            this.total_cost_create = total_cost_create;

            this.list_of_products = list_of_products;

            this.addOrderAgain = addOrderAgain;
        }

        static ViewHolder create(RelativeLayout rootView) {
            TextView number = rootView.findViewById(R.id.number);
            TextView date_create = rootView.findViewById(R.id.date_create);
            TextView restaurant_create = rootView.findViewById(R.id.restaurant_create);
            TextView status_create = rootView.findViewById(R.id.status_create);
            TextView what_todo_create = rootView.findViewById(R.id.what_todo_create);
            TextView delivery_create = rootView.findViewById(R.id.delivery_create);
            TextView peoples_create = rootView.findViewById(R.id.peoples_create);
            TextView time_of_delivery_create = rootView.findViewById(R.id.time_of_delivery_create);
            TextView comment_create = rootView.findViewById(R.id.comment_create);
            TextView total_cost_create = rootView.findViewById(R.id.total_cost_create);

            ListView list_of_products = rootView.findViewById(R.id.list_products);

            Button addOrderAgain = rootView.findViewById(R.id.button_add_in_orders);

            return new ViewHolder(rootView, number, date_create, restaurant_create, status_create, what_todo_create, delivery_create, peoples_create,
                    time_of_delivery_create, comment_create, total_cost_create, list_of_products, addOrderAgain);
        }

    }

}
