package ru.ianasimonenko.fragmentproject;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import ru.ianasimonenko.fragmentproject.OrdersModel.Order;

public class OrdersDataAdapter2 extends ArrayAdapter<Order> {
    List<Order> list;

    Context context;
    private LayoutInflater inflater;

    public OrdersDataAdapter2(Context context, List<Order> objects) {
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
        final ViewHolder vh;

        if(convertView == null) {
            View view = inflater.inflate(R.layout.products_row, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Order item = getItem(position);

        vh.pos_name.setText(item.getPositions().get(0).getPosition().getName());
        vh.pos_quantity.setText(item.getPositions().get(0).getQuantity().toString());
        vh.pos_price.setText(item.getPositions().get(0).getPosition().getPrice().toString());
        vh.pos_total.setText(item.getPositions().get(0).getPriceTotal().toString());


        return vh.rootView;
    }

    public static class ViewHolder {

        public final RelativeLayout rootView;
        public final TextView pos_name;
        public final TextView pos_quantity;
        public final TextView pos_price;
        public final TextView pos_total;

        private ViewHolder(RelativeLayout rootView, TextView pos_name, TextView pos_quantity, TextView pos_price, TextView pos_total) {
            this.rootView = rootView;
            this.pos_name = pos_name;
            this.pos_quantity = pos_quantity;
            this.pos_price = pos_price;
            this.pos_total = pos_total;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView pos_name = (TextView) rootView.findViewById(R.id.pos_name);
            TextView pos_quantity = (TextView) rootView.findViewById(R.id.pos_quantity);
            TextView pos_price = (TextView) rootView.findViewById(R.id.pos_price);
            TextView pos_total = (TextView) rootView.findViewById(R.id.pos_total);

            return new ViewHolder(rootView, pos_name, pos_quantity, pos_price, pos_total);
        }

    }

}
