package ru.naparahandroid.fragmentproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.naparahandroid.fragmentproject.Profile.Interface.ProfileGet;
import ru.naparahandroid.fragmentproject.Profile.Model.Example;
import ru.naparahandroid.fragmentproject.Profile.Model.GET.ClientProfile;
import ru.naparahandroid.fragmentproject.Profile.Model.GET.Status;
import ru.naparahandroid.fragmentproject.dummy.DummyContent.DummyItem;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ProfileFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private OnListFragmentInteractionListener mListener;

    private ClientProfile data;
    private ClientDataAdapter adapter;
    private ListView listView;
    
    private Example profileFromAdapter;
	private String accessToken;
    //
//    TextView full_name;
//    TextView phone;
//    TextView fName;
//    TextView lName;
//    TextView email;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProfileFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ProfileFragment newInstance(int columnCount) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            // TODO: Customize parameters
            int mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_list, container, false);


        data = new ClientProfile();
//        View parentView = view.findViewById(R.id.parent_client_view);
        listView = view.findViewById(R.id.listViewProfile);
	
	    LocalBroadcastManager.getInstance(inflater.getContext()).registerReceiver(mMessageReceiver,
			    new IntentFilter("custom-message"));

//        Button button = view.findViewById(R.id.edit_button);
//        button.setOnClickListener(v -> {
//            Intent intent = new Intent(ProfileFragment.this.getActivity(), EditProfileActivity.class);
//            startActivity(intent);
//        });

        // Set the adapter
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://naparah.olegb.ru/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        final ProfileGet userClient = retrofit.create(ProfileGet.class);

        LoginActivity activity = new LoginActivity();
        String accessToken = activity.getMyTokenFromLogin();

        Call<Status> call = userClient.getProfile(accessToken, "get");

        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(@NonNull Call<Status> call, @NonNull Response<Status> response) {

                if (response.isSuccessful()) {

                    Toast.makeText(inflater.getContext(), "Данные профиля успешно получены",
                            Toast.LENGTH_LONG).show();

                    assert response.body() != null;
                    data = response.body().getClientProfile();
                    adapter = new ClientDataAdapter(inflater.getContext(), data);
                    listView.setAdapter(adapter);
                    
                    
                    
                }

            }

            @Override
            public void onFailure(@NonNull Call<Status> call, @NonNull Throwable t) {

            }
        });



        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
	
	public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			Serializable idAdapter = intent.getSerializableExtra("listProfile");
			profileFromAdapter = ( Example ) idAdapter;
			Toast.makeText(context, "Profile: "+idAdapter,
					Toast.LENGTH_SHORT).show();
		}
	};
    
    private void editProfile() {
	    LoginActivity activity = new LoginActivity();
	    accessToken = activity.getMyTokenFromLogin();
	    ApiService api = RetrofitClient.getApiService();
	
	    Call< Example > call = api.postEditProfile( accessToken, profileFromAdapter );
	    call.enqueue( new Callback < Example >( ) {
		    @Override
		    public void onResponse( Call < Example > call , Response < Example > response ) {
		    	
		    	if (response.isSuccessful()) {
		    		Toast.makeText( ProfileFragment.this.getContext(), "SUCCESS", Toast.LENGTH_SHORT ).show();
			    } else {
				    Toast.makeText( ProfileFragment.this.getContext(), "NOT SUCCESS "+ profileFromAdapter, Toast.LENGTH_SHORT ).show();
			    }
			
		    }
		
		    @Override
		    public void onFailure( Call < Example > call , Throwable t ) {
			    Toast.makeText( ProfileFragment.this.getContext(), "ERROR "+t.getMessage(), Toast.LENGTH_SHORT ).show();
		    }
	    } );
    }
}
