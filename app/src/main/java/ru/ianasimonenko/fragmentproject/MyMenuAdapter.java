package ru.ianasimonenko.fragmentproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
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

import ru.ianasimonenko.fragmentproject.Model.Menu;

class MyMenuAdapter extends ArrayAdapter<Menu> {

    private final List<Menu> contactList;
    private final Context context;
    private final LayoutInflater mInflater;

    // Constructors
    public MyMenuAdapter(Context context, ArrayList<Menu> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }

    @Override
    public Menu getItem(int position) {
        return contactList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.fragment_item, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Menu item = getItem(position);

        assert item != null;
        vh.textViewName.setText(item.getName());
//        vh.textViewSlug.setText(item.getSlug());
//        vh.textViewId.setText(item.getId());
        Picasso.with(context).load(item.getImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);
//        Picasso.with(context).load(item.getBgImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageViewBg);

        vh.testButton.setOnClickListener(v -> {
            Intent intent = new Intent(MyMenuAdapter.this.getContext(), Product34Activity.class);
            MyMenuAdapter.this.getContext().startActivities(new Intent[]{intent});
        });

        return vh.rootView;
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