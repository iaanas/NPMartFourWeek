package ru.ianasimonenko.fragmentproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;

public class BasketTotalAdapter  extends ArrayAdapter<GenBasket> {


    List<GenBasket> list;

    Context context;
    private LayoutInflater inflater;


    public BasketTotalAdapter(Context context, List<GenBasket> objects) {
        super(context, 0, objects);

        this.context = context;
        this.inflater = LayoutInflater.from(context);
        list = objects;
    }

    @Override
    public GenBasket getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final BasketTotalAdapter.ViewHolder vh;

        if(convertView == null) {
            View view = inflater.inflate(R.layout.fragment_total_basket, parent, false);
            vh = BasketTotalAdapter.ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (BasketTotalAdapter.ViewHolder) convertView.getTag();
        }

        GenBasket item = getItem(position);

        vh.priceTotal.setText("ИТОГО "+item.getPriceTotal().toString()+" РУБ.");
        vh.caloriesTotal.setText(item.getCaloriesTotal().toString()+" ккал");

        return vh.rootView;


    }

    private static class ViewHolder {

        public final RelativeLayout rootView;
        public final TextView priceTotal;
        public final TextView caloriesTotal;

        private ViewHolder(RelativeLayout rootView, TextView priceTotal,
                           TextView caloriesTotal) {
            this.rootView = rootView;
            this.priceTotal = priceTotal;
            this.caloriesTotal = caloriesTotal;
        }

        public static BasketTotalAdapter.ViewHolder create(RelativeLayout rootView) {
            TextView priceTotal = (TextView) rootView.findViewById(R.id.total_price);
            TextView caloriesTotal = (TextView) rootView.findViewById(R.id.total_calories);

            return new BasketTotalAdapter.ViewHolder(rootView, priceTotal, caloriesTotal);
        }

    }
}
