package ru.naparahandroid.fragmentproject;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import ru.naparahandroid.fragmentproject.InnerMenu.Category;
import ru.naparahandroid.fragmentproject.InnerMenu.Dish;

public class MyInnerMenuAdapter extends ArrayAdapter<Category> {
    private final List<Category> contactList;
    private final Context context;
    private final LayoutInflater mInflater;

    private SendData sendData;

    private Integer finId;


    // Constructors
    public MyInnerMenuAdapter(Context context, ArrayList<Category> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }


    @Override
    public Category getItem(int position) {
        return contactList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.inner_menu, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Category item = getItem(position);


        assert item != null;
//        vh.textViewName.setText(item.getName());
//        vh.textViewSlug.setText(item.getSlug());
//        vh.textViewId.setText(item.getId());
//        Picasso.with(context).load(item.getMenu().getImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);
//        Picasso.with(context).load(item.getBgImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageViewBg);

        vh.testButton.setText(item.getName());

        vh.testButton.setOnClickListener(v -> {

            Intent intent = new Intent("custom-message");
            final ArrayList<Dish> list = new ArrayList<>(item.getDishes());
            intent.putExtra("listDish", list);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);

        });

        return vh.rootView;
    }

    public interface SendData {
        void onItemSelected(Integer id);
    }

    public void setOnItemSelected(SendData sendData) {
        this.sendData = sendData;
    }

    public Integer sendIdFromAdapter() {
        return finId;
    }



    private static class ViewHolder {
        final RelativeLayout rootView;
        final ImageView imageView;
        final ImageView imageViewBg;
        final TextView textViewName;
        final TextView textViewSlug;
        final TextView textViewId;

        final Button testButton;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName, Button testButton) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.imageViewBg = null;
            this.textViewName = textViewName;
            this.textViewSlug = null;
            this.textViewId = null;
            this.testButton = testButton;
        }

        static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = rootView.findViewById(R.id.image);
//            ImageView imageViewBg = (ImageView) rootView.findViewById(R.id.bg_image);
            TextView textViewName = rootView.findViewById(R.id.name);
//            TextView textViewSlug = (TextView) rootView.findViewById(R.id.slug);
//            TextView textViewId = (TextView) rootView.findViewById(R.id.id);
            Button testButton = rootView.findViewById(R.id.button_for_test_prod);
            return new ViewHolder(rootView, imageView, textViewName, testButton);
        }
    }
}
