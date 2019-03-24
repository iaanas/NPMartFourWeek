package ru.naparahandroid.fragmentproject;

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

import java.util.List;

import ru.naparahandroid.fragmentproject.Products.GenProducts;


class ProdAdapter extends ArrayAdapter<GenProducts> {

    private final List<GenProducts> contactList;
    private final Context context;
    private final LayoutInflater mInflater;

    // Constructors
    public ProdAdapter(Context context, List<GenProducts> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }

    @Override
    public GenProducts getItem(int position) {
        return contactList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final ProdAdapter.ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.menu_row, parent, false);
            vh = ProdAdapter.ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ProdAdapter.ViewHolder) convertView.getTag();
        }

        GenProducts item = getItem(position);

        assert item != null;
        vh.textViewName.setText(item.getDish().getName());
        vh.textViewDescription.setText(item.getDish().getDescription());
        vh.textViewCalories.setText(item.getDish().getCalories());
        vh.textViewGrams.setText(item.getDish().getGrams());
        vh.textViewPrice.setText(item.getDish().getPrice());

        Picasso.with(context).load(String.valueOf(item.getDish().getParts())).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);
//        Picasso.with(context).load(item.getBgImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageViewBg);

        return vh.rootView;
    }

    private static class ViewHolder {
        final RelativeLayout rootView;
        final ImageView imageView;
        final TextView textViewName;
        final TextView textViewPrice;
        final TextView textViewGrams;
        final TextView textViewCalories;
        final TextView textViewDescription;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName, TextView textViewPrice, TextView textViewGrams, TextView textViewCalories, TextView textViewDescription) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewName = textViewName;
            this.textViewPrice = textViewPrice;
            this.textViewGrams= textViewGrams;
            this.textViewCalories = textViewCalories;
            this.textViewDescription = textViewDescription;
        }

        static ProdAdapter.ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = rootView.findViewById(R.id.product_image);
            TextView textViewName = rootView.findViewById(R.id.product_name);
            TextView textViewPrice = rootView.findViewById(R.id.product_price);
            TextView textViewGrams = rootView.findViewById(R.id.product_grams);
            TextView textViewCalories = rootView.findViewById(R.id.product_calories);
            TextView textViewDescription = rootView.findViewById(R.id.product_description);
            return new ProdAdapter.ViewHolder(rootView, imageView, textViewName, textViewPrice, textViewGrams, textViewCalories, textViewDescription);
        }
    }
}
