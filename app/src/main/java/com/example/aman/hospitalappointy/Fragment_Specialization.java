package com.example.aman.hospitalappointy;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

/**
 * Created by Aman on 14-Feb-18.
 */

public class Fragment_Specialization extends Fragment {

    private Button mDocProfile;

    public Fragment_Specialization(){
        //Required Empty public constructor otherwise app will crash
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_specialization,container,false);

        mDocProfile = (Button) rootView.findViewById(R.id.doc_profile);
        mDocProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent special_Intent = new Intent(rootView.getContext(), Patient_DoctorProfileActivity.class);
                startActivity(special_Intent);
            }
        });

        return rootView;
    }


}
