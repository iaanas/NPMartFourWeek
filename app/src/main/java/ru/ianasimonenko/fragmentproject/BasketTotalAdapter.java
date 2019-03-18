package ru.ianasimonenko.fragmentproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ru.ianasimonenko.fragmentproject.BasketModel.BasketPosition;
import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;
import ru.ianasimonenko.fragmentproject.SendOrderFragments.InHouseActivity;

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

        if(item.getPriceTotal()<1000) {

            vh.buttonOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context,
                            AlertDialog.THEME_HOLO_LIGHT);
                    builder.setTitle("Минимальная сумма заказа - 1000 руб.");
                    builder.setMessage("Вы хотите положить еще чего-нибудь вкусного в корзину?");
                    builder.setNegativeButton("Нет, пока не хочу",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    builder.setPositiveButton("Да, хочу", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(context, HomeActivity.class);
                            context.startActivities(new Intent[]{intent});
                        }
                    });
                    builder.show();
                }
            });

        } else {
            vh.buttonOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SendOrderActivity.class);
                    context.startActivities(new Intent[]{intent});
                }
            });
        }


        return vh.rootView;


    }

    private static class ViewHolder {

        public final RelativeLayout rootView;
        public final TextView priceTotal;
        public final TextView caloriesTotal;
        public final Button buttonOrder;

        private ViewHolder(RelativeLayout rootView, TextView priceTotal,
                           TextView caloriesTotal, Button buttonOrder) {
            this.rootView = rootView;
            this.priceTotal = priceTotal;
            this.caloriesTotal = caloriesTotal;
            this.buttonOrder = buttonOrder;
        }

        public static BasketTotalAdapter.ViewHolder create(RelativeLayout rootView) {
            TextView priceTotal = (TextView) rootView.findViewById(R.id.total_price);
            TextView caloriesTotal = (TextView) rootView.findViewById(R.id.total_calories);
            Button buttonOrder = (Button) rootView.findViewById(R.id.button_order);

            return new BasketTotalAdapter.ViewHolder(rootView, priceTotal, caloriesTotal,
                          buttonOrder);
        }

    }
}
