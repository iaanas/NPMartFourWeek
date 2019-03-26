package ru.naparahandroid.fragmentproject;

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

import ru.naparahandroid.fragmentproject.InnerMenu.Dish;

public class InnerMennuAdapter extends ArrayAdapter<Dish> {

    private final List<Dish> contactList;
    private final Context context;
    private final LayoutInflater mInflater;

    // Constructors
    public InnerMennuAdapter(Context context, ArrayList<Dish> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }


    @Override
    public Dish getItem(int position) {
        return contactList.get(position);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.inner_menu_fragment, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Dish item = getItem(position);


        assert item != null;

        vh.textViewName.setText(item.getName());
        vh.textViewPrice.setText(item.getPrice().toString());

        if (item.getGrams() != null && item.getCalories() != null) {
            vh.textViewGrams.setText(item.getGrams().toString());
            vh.textViewCalories.setText(item.getCalories().toString());
        } else {
            vh.textViewGrams.setText("-");
            vh.textViewCalories.setText("-");
        }

        vh.textViewDescription.setText(item.getDescription());

        Picasso.with(context).load(String.valueOf(item.getImages())).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);



        return vh.rootView;
    }


    private static class ViewHolder {
        final RelativeLayout rootView;
        final TextView textViewName;
        final TextView textViewPrice;
        final TextView textViewGrams;
        final TextView textViewCalories;
        final TextView textViewDescription;
        final ImageView imageView;

        private ViewHolder(RelativeLayout rootView, TextView textViewName, TextView textViewPrice, TextView textViewGrams, TextView textViewCalories, TextView textViewDescription,
                           ImageView imageView) {
            this.rootView = rootView;
            this.textViewName = textViewName;
            this.textViewPrice = textViewPrice;
            this.textViewGrams = textViewGrams;
            this.textViewCalories = textViewCalories;
            this.textViewDescription = textViewDescription;
            this.imageView = imageView;
        }

        static ViewHolder create(RelativeLayout rootView) {
            TextView textViewName = rootView.findViewById(R.id.name);
            TextView textViewPrice = rootView.findViewById(R.id.price);
            TextView textViewGrams = rootView.findViewById(R.id.grams);
            TextView textViewCalories = rootView.findViewById(R.id.calories);
            TextView textViewDescription = rootView.findViewById(R.id.descriptions);
            ImageView imageView = rootView.findViewById(R.id.image);
            return new ViewHolder(rootView, textViewName, textViewPrice, textViewGrams, textViewCalories, textViewDescription, imageView);
        }
    }
}
