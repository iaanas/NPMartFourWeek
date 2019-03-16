package ru.ianasimonenko.fragmentproject;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.OrdersModel.Order;

public class OrdersDataAdapter extends ArrayAdapter<Order> {
    List<Order> list;

    Context context;
    private LayoutInflater inflater;

    private OrdersDataAdapter2 adapter2;

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


    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;

        if(convertView == null) {
            View view = inflater.inflate(R.layout.orders_row, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Order item = getItem(position);

        vh.number.setText(item.getNumber().toString());

        vh.date_create.setText(item.getCreated().toString());

        vh.restaurant_create.setText(item.getRestaurant().getName());

        vh.status_create.setText(item.getReadableState());

        vh.what_todo_create.setText(item.getReadablePresenceState());

        vh.delivery_create.setText(item.getAddress());

        vh.peoples_create.setText(item.getPeopleAmount().toString());

        vh.time_of_delivery_create.setText(item.getArriving().toString());

        vh.comment_create.setText(item.getComment());

        vh.total_cost_create.setText(item.getPriceTotal().toString());


        return vh.rootView;
    }

    public static class ViewHolder {

        public final RelativeLayout rootView;
        public final TextView number;
        public final TextView date_create;
        public final TextView restaurant_create;
        public final TextView status_create;
        public final TextView what_todo_create;
        public final TextView delivery_create;
        public final TextView peoples_create;
        public final TextView time_of_delivery_create;
        public final TextView comment_create;
        public final TextView total_cost_create;

        public final ListView list_of_products;

        private ViewHolder(RelativeLayout rootView, TextView number, TextView date_create, TextView restaurant_create, TextView status_create,
                           TextView what_todo_create, TextView delivery_create, TextView peoples_create, TextView time_of_delivery_create,
                           TextView comment_create, TextView total_cost_create, ListView list_of_products) {
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
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView number = (TextView) rootView.findViewById(R.id.number);
            TextView date_create = (TextView) rootView.findViewById(R.id.date_create);
            TextView restaurant_create = (TextView) rootView.findViewById(R.id.restaurant_create);
            TextView status_create = (TextView) rootView.findViewById(R.id.status_create);
            TextView what_todo_create = (TextView) rootView.findViewById(R.id.what_todo_create);
            TextView delivery_create = (TextView) rootView.findViewById(R.id.delivery_create);
            TextView peoples_create = (TextView) rootView.findViewById(R.id.peoples_create);
            TextView time_of_delivery_create = (TextView) rootView.findViewById(R.id.time_of_delivery_create);
            TextView comment_create = (TextView) rootView.findViewById(R.id.comment_create);
            TextView total_cost_create = (TextView) rootView.findViewById(R.id.total_cost_create);

            ListView list_of_products = (ListView) rootView.findViewById(R.id.list_products);

            return new ViewHolder(rootView, number, date_create, restaurant_create, status_create, what_todo_create, delivery_create, peoples_create,
                    time_of_delivery_create, comment_create, total_cost_create, list_of_products);
        }

    }

}
