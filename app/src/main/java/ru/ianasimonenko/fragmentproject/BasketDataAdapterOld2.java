package ru.ianasimonenko.fragmentproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.OrdersModel.Order;

public class BasketDataAdapterOld2 extends ArrayAdapter<Order> {

    List<Order> list;

    Context context;
    private LayoutInflater inflater;


    public BasketDataAdapterOld2(@NonNull Context context, @NonNull List<Order> objects) {
        super(context, 0, objects);

        this.context = context;
        this.inflater = LayoutInflater.from(context);
        list = objects;
    }

    @Override
    public Order getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.basket_row2, parent, false);

        TextView txtUserId = (TextView) rowView.findViewById(R.id.bask_name);

        txtUserId.setText(String.format("#ID: %d", list.get(position).getRestaurant().getName()));

        return rowView;


    }

    public static class ViewHolder {

        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView quantity;
        public final TextView price_single_item;
        public final TextView price_sub_items;
        public final TextView price_total;
        public final TextView name_of_position;

        private ViewHolder(RelativeLayout rootView, ImageView imageView,
                           TextView quantity, TextView price_single_item,
                           TextView price_sub_items, TextView price_total,
                           TextView name_of_position) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.quantity = quantity;
            this.price_single_item = price_single_item;
            this.price_sub_items = price_sub_items;
            this.price_total = price_total;
            this.name_of_position = name_of_position;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.bask_image);
            TextView quantity = (TextView) rootView.findViewById(R.id.bask_count);
            TextView price_single_item = (TextView) rootView.findViewById(R.id.bask_cost_item);
            TextView price_sub_items = (TextView) rootView.findViewById(R.id.bask_subItems);
            TextView price_total = (TextView) rootView.findViewById(R.id.bask_cost_total);
            TextView name_of_position = (TextView) rootView.findViewById(R.id.bask_name);

            return new ViewHolder(rootView, imageView, quantity, price_single_item,
                    price_sub_items, price_total, name_of_position);
        }

    }
}
