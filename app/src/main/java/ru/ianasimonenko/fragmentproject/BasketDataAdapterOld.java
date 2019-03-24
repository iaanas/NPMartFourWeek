package ru.ianasimonenko.fragmentproject;

import android.annotation.SuppressLint;
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

class BasketDataAdapterOld extends ArrayAdapter<BasketPosition> {

    private final List<BasketPosition> list;

    private final Context context;
    private final LayoutInflater inflater;


    public BasketDataAdapterOld(Context context, List<BasketPosition> objects) {
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
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
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
//        vh.price_sub_items.setText(item.getPriceSubitems().toString());
        String TOTAL_SUM = "Итого: ";
        vh.price_total.setText(TOTAL_SUM +String.valueOf(item.getPriceTotal()));

        return vh.rootView;


    }

    public static class ViewHolder {

        final RelativeLayout rootView;
        final ImageView imageView;
        final TextView quantity;
        final TextView price_single_item;
        final TextView price_sub_items;
        final TextView price_total;
        final TextView name_of_position;

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

        static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = rootView.findViewById(R.id.bask_image);
            TextView quantity = rootView.findViewById(R.id.bask_count);
            TextView price_single_item = rootView.findViewById(R.id.bask_cost_item);
            TextView price_sub_items = rootView.findViewById(R.id.bask_subItems);
            TextView price_total = rootView.findViewById(R.id.bask_cost_total);
            TextView name_of_position = rootView.findViewById(R.id.bask_name);

            return new ViewHolder(rootView, imageView, quantity, price_single_item,
                    price_sub_items, price_total, name_of_position);
        }

    }
}
