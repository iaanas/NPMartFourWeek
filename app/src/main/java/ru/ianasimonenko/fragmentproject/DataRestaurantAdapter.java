package ru.ianasimonenko.fragmentproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ru.ianasimonenko.fragmentproject.Model.Restaurant;

public class DataRestaurantAdapter extends RecyclerView.Adapter<DataRestaurantAdapter.ViewHolder>{

    private ArrayList<Restaurant> restaurants;

    public DataRestaurantAdapter(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public DataRestaurantAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataRestaurantAdapter.ViewHolder holder, int position) {
        holder.opening_hours.setText(restaurants.get(position).getOpeningHours());
        holder.restaurant_name.setText(restaurants.get(position).getRestaurantName());
//        holder.restaurant_id.setText(restaurants.get(position).getRestaurantId());
        holder.lat.setText(restaurants.get(position).getLat());
        holder.longItem.setText(restaurants.get(position).getLong());
//        holder.images.addView((ListView)restaurants.get(position).getImages());
//        holder.phones.addView((ListView) restaurants.get(position).getPhones());
        holder.address.setText(restaurants.get(position).getAddress());
//        holder.menus.addView((ListView) restaurants.get(position).getMenus());
//        holder.metros.addView((ListView) restaurants.get(position).getMetros());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView opening_hours;
        private TextView restaurant_name;
//        private TextView restaurant_id;
        private TextView lat;
        private TextView longItem;
//        private ListView images;
//        private ListView phones;
        private TextView address;
//        private ListView menus;
//        private ListView metros;

        public ViewHolder(View itemView) {
            super(itemView);

            opening_hours = (TextView) itemView.findViewById(R.id.opening_hours);
            restaurant_name = (TextView) itemView.findViewById(R.id.restaurant_name);
//            restaurant_id = (TextView) itemView.findViewById(R.id.restaurant_id);
            lat = (TextView) itemView.findViewById(R.id.lat);
            longItem = (TextView) itemView.findViewById(R.id._long);
//            images = (ListView) itemView.findViewById(R.id.images);
//            phones = (ListView) itemView.findViewById(R.id.phones);
            address = (TextView) itemView.findViewById(R.id.address);
//            menus = (ListView) itemView.findViewById(R.id.menus);
//            metros = (ListView) itemView.findViewById(R.id.metros);

        }
    }
}
