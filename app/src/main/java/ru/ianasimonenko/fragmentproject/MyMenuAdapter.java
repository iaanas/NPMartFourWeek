package ru.ianasimonenko.fragmentproject;

import android.content.Context;
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

import ru.ianasimonenko.fragmentproject.Model.Menu;

public class MyMenuAdapter extends ArrayAdapter<Menu> {

    List<Menu> contactList;
    Context context;
    private LayoutInflater mInflater;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.fragment_item, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Menu item = getItem(position);

        vh.textViewName.setText(item.getName());
//        vh.textViewSlug.setText(item.getSlug());
//        vh.textViewId.setText(item.getId());
        Picasso.with(context).load(item.getImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);
//        Picasso.with(context).load(item.getBgImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageViewBg);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final ImageView imageViewBg;
        public final TextView textViewName;
        public final TextView textViewSlug;
        public final TextView textViewId;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, ImageView imageViewBg, TextView textViewName, TextView textViewSlug, TextView textViewId) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.imageViewBg = imageViewBg;
            this.textViewName = textViewName;
            this.textViewSlug = textViewSlug;
            this.textViewId = textViewId;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.image);
//            ImageView imageViewBg = (ImageView) rootView.findViewById(R.id.bg_image);
            TextView textViewName = (TextView) rootView.findViewById(R.id.name);
//            TextView textViewSlug = (TextView) rootView.findViewById(R.id.slug);
//            TextView textViewId = (TextView) rootView.findViewById(R.id.id);
            return new ViewHolder(rootView, imageView, null, textViewName, null, null);
        }
    }
}