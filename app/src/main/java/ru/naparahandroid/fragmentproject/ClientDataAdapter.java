package ru.naparahandroid.fragmentproject;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.naparahandroid.fragmentproject.InnerMenu.Dish;
import ru.naparahandroid.fragmentproject.Profile.Model.Birthday;
import ru.naparahandroid.fragmentproject.Profile.Model.Example;
import ru.naparahandroid.fragmentproject.Profile.Model.GET.ClientProfile;

class ClientDataAdapter extends ArrayAdapter<ClientProfile> {
    
    private Integer mYear, mMonth, mDay;
    private EditText currentDateTime;
    private Birthday bDay;
    
    private String eMail, fStrName, lStrname;
    private Boolean checked;
    private String accessToken;
    private Example profile;
    
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

//        TextView phone = convertView.findViewById(R.id.phone_in_header);
        EditText fName = convertView.findViewById(R.id.first_name);
        EditText lName = convertView.findViewById(R.id.last_name);
        EditText email = convertView.findViewById(R.id.email);
        
        TextView fullName = convertView.findViewById( R.id.full_name );
        TextView phoneMain = convertView.findViewById( R.id.phone );
        TextView loyaltyBonus = convertView.findViewById( R.id.loyalty_bonus );
    
        Button dateButton = convertView.findViewById( R.id.btn_date );
        currentDateTime = convertView.findViewById( R.id.picked_date );
    
        CheckBox checkBox = convertView.findViewById(R.id.checkbox);
        checked = checkBox.isChecked();
        
        dateButton.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick( View v ) {
                dateClick();
                bDay = new Birthday( mDay, mMonth, mYear );
            }
        } );
        
        assert clientProfile != null;
        String NAME = "Имя: ";
        fName.setText(NAME +String.valueOf(clientProfile.getFirstName()));
        String SONAME = "Фамилия: ";
        lName.setText(SONAME +String.valueOf(clientProfile.getLastName()));
        String EMAIL = "E-mail: ";
        email.setText(EMAIL +String.valueOf(clientProfile.getEmail()));
    
//        profile = new Example( bDay, eMail, fStrName, lStrname, checked, "change_user_info" );
        
        Button editButton = convertView.findViewById( R.id.edit_profile_button );
        editButton.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick( View v ) {
                eMail = email.toString();
                fStrName = fName.toString();
                lStrname = lName.toString();
    
                profile = new Example( bDay, "i@i.ru", "iana", "simonenko", true, "change_user_info" );
                
                editProfile( profile );
        
            }
        } );
        
        
        if (clientProfile.getLoyaltyPoints().toString() == null) {
            loyaltyBonus.setText( "0 бонусных баллов" );
        } else {
            loyaltyBonus.setText( clientProfile.getLoyaltyPoints().toString()+" бонусных баллов" );
        }
        
        fullName.setText( clientProfile.getFirstName() + " " + clientProfile.getLastName() );
        phoneMain.setText( "+"+clientProfile.getPhone() );

        return convertView;
    }
    
    public void dateClick() {
    
        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);
    
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String editTextDateParam = dayOfMonth + "." + (monthOfYear + 1) + "." + year;
                        currentDateTime.setText(editTextDateParam);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
        
        
        
    }
    
    private void editProfile(Example profile) {
        LoginActivity activity = new LoginActivity();
        accessToken = activity.getMyTokenFromLogin();
        ApiService api = RetrofitClient.getApiService();
        
        Call< Example > call = api.postEditProfile( accessToken, profile );
        call.enqueue( new Callback< Example >( ) {
            @Override
            public void onResponse( Call < Example > call , Response< Example > response ) {
                
                if (response.isSuccessful()) {
                    Toast.makeText( ClientDataAdapter.this.getContext(), "SUCCESS", Toast.LENGTH_SHORT ).show();
                } else {
                    Toast.makeText( ClientDataAdapter.this.getContext(), "NOT SUCCESS "+bDay, Toast.LENGTH_SHORT ).show();
                }
                
            }
            
            @Override
            public void onFailure( Call < Example > call , Throwable t ) {
                Toast.makeText( ClientDataAdapter.this.getContext(), "ERROR "+t.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );
    }
    
    
}
