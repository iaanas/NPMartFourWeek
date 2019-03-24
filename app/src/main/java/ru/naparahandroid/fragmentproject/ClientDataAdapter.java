package ru.naparahandroid.fragmentproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Collections;

import ru.naparahandroid.fragmentproject.Profile.Model.GET.ClientProfile;

class ClientDataAdapter extends ArrayAdapter<ClientProfile> {

    public ClientDataAdapter(Context context, ClientProfile clientProfile) {
        super(context, 0, Collections.singletonList(clientProfile));
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ClientProfile clientProfile = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile,
                    parent, false);
        }

        TextView phone = convertView.findViewById(R.id.phone_in_header);
        TextView fName = convertView.findViewById(R.id.first_name);
        TextView lName = convertView.findViewById(R.id.last_name);
        TextView email = convertView.findViewById(R.id.email);

        assert clientProfile != null;
        String NAME = "Имя: ";
        fName.setText(NAME +String.valueOf(clientProfile.getFirstName()));
        String SONAME = "Фамилия: ";
        lName.setText(SONAME +String.valueOf(clientProfile.getLastName()));
        String EMAIL = "E-mail: ";
        email.setText(EMAIL +String.valueOf(clientProfile.getEmail()));
        String PHONE = "Номер телефона: ";
        phone.setText(PHONE +String.valueOf(clientProfile.getPhone()));

        return convertView;
    }
}
