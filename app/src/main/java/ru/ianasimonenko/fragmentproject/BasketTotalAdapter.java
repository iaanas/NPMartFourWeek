package ru.ianasimonenko.fragmentproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import ru.ianasimonenko.fragmentproject.BasketModel.GenBasket;

class BasketTotalAdapter  extends ArrayAdapter<GenBasket> {


    private final List<GenBasket> list;

    private final Context context;
    private final LayoutInflater inflater;


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

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final BasketTotalAdapter.ViewHolder vh;

        if(convertView == null) {
            View view = inflater.inflate(R.layout.fragment_total_basket, parent, false);
            vh = BasketTotalAdapter.ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (BasketTotalAdapter.ViewHolder) convertView.getTag();
        }

        GenBasket item = getItem(position);

        assert item != null;
        String MONEY_CHOOSE = " РУБ.";
        String TOTAL_SUM = "Итого: ";
        vh.priceTotal.setText(TOTAL_SUM +String.valueOf(item.getPriceTotal())+ MONEY_CHOOSE);
        String CCALL = " ккал.";
        vh.caloriesTotal.setText(String.valueOf(item.getCaloriesTotal())+ CCALL);

        if(item.getPriceTotal()<1000) {

            vh.buttonOrder.setOnClickListener(v -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(context,
                        AlertDialog.THEME_HOLO_LIGHT);
                builder.setTitle("Минимальная сумма заказа - 1000 руб.");
                builder.setMessage("Вы хотите положить еще чего-нибудь вкусного в корзину?");
                builder.setNegativeButton("Нет, пока не хочу",
                        (dialog, which) -> dialog.cancel());
                builder.setPositiveButton("Да, хочу", (dialog, which) -> {
                    Intent intent = new Intent(context, HomeActivity.class);
                    context.startActivities(new Intent[]{intent});
                });
                builder.show();
            });

        } else {
            vh.buttonOrder.setOnClickListener(v -> {
                Intent intent = new Intent(context, SendOrderActivity.class);
                context.startActivities(new Intent[]{intent});
            });
        }


        return vh.rootView;


    }

    private static class ViewHolder {

        final RelativeLayout rootView;
        final TextView priceTotal;
        final TextView caloriesTotal;
        final Button buttonOrder;

        private ViewHolder(RelativeLayout rootView, TextView priceTotal,
                           TextView caloriesTotal, Button buttonOrder) {
            this.rootView = rootView;
            this.priceTotal = priceTotal;
            this.caloriesTotal = caloriesTotal;
            this.buttonOrder = buttonOrder;
        }

        static BasketTotalAdapter.ViewHolder create(RelativeLayout rootView) {
            TextView priceTotal = rootView.findViewById(R.id.total_price);
            TextView caloriesTotal = rootView.findViewById(R.id.total_calories);
            Button buttonOrder = rootView.findViewById(R.id.button_order);

            return new BasketTotalAdapter.ViewHolder(rootView, priceTotal, caloriesTotal,
                          buttonOrder);
        }

    }
}
