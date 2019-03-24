package ru.ianasimonenko.fragmentproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Collections;

import ru.ianasimonenko.fragmentproject.Profile.Model.GET.Client;

class ClientDataAdapter extends ArrayAdapter<Client> {

    public ClientDataAdapter(Context context, Client client) {
        super(context, 0, Collections.singletonList(client));
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Client client = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile,
                    parent, false);
        }

        TextView phone = convertView.findViewById(R.id.phone_in_header);
        TextView fName = convertView.findViewById(R.id.first_name);
        TextView lName = convertView.findViewById(R.id.last_name);
        TextView email = convertView.findViewById(R.id.email);

        assert client != null;
        String NAME = "Имя: ";
        fName.setText(NAME +String.valueOf(client.getFirstName()));
        String SONAME = "Фамилия: ";
        lName.setText(SONAME +String.valueOf(client.getLastName()));
        String EMAIL = "E-mail: ";
        email.setText(EMAIL +String.valueOf(client.getEmail()));
        String PHONE = "Номер телефона: ";
        phone.setText(PHONE +String.valueOf(client.getPhone()));

        return convertView;
    }
}
