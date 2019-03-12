package ru.ianasimonenko.fragmentproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.ianasimonenko.fragmentproject.Profile.Model.GET.Client;

public class ClientDataAdapter extends ArrayAdapter<Client> {


    public ClientDataAdapter(Context context, Client client) {
        super(context, 0, Collections.singletonList(client));
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Client client = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile,
                    parent, false);
        }

        TextView phone = (TextView) convertView.findViewById(R.id.phone_in_header);
        TextView fName = (TextView) convertView.findViewById(R.id.first_name);
        TextView lName = (TextView) convertView.findViewById(R.id.last_name);
        TextView email = (TextView) convertView.findViewById(R.id.email);

        fName.setText("Имя: "+String.valueOf(client.getFirstName()));
        lName.setText("Фамилия: "+String.valueOf(client.getLastName()));
        email.setText("E-mail: "+String.valueOf(client.getEmail()));
        phone.setText("Номер телефона: "+String.valueOf(client.getPhone()));

        return convertView;
    }
}
