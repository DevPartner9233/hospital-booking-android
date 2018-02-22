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
    private Button mPersonal;
    private Button mRosterPlan;
    private Button mEditRosterPlan;
    private Button mEditProfile;

    public Fragment_Specialization(){
        //Required Empty public constructor otherwise app will crash
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_specialization,container,false);

        mDocProfile = (Button) rootView.findViewById(R.id.doc_profile);
        mPersonal = (Button) rootView.findViewById(R.id.doctor_profile);
        mRosterPlan = (Button) rootView.findViewById(R.id.doctor_rosterPlan_btn);
        mEditRosterPlan = (Button) rootView.findViewById(R.id.doctor_editRoasterPlan_btn);
        mEditProfile = (Button) rootView.findViewById(R.id.doctor_editProfile_btn);


        mDocProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent special_Intent = new Intent(rootView.getContext(), Patient_DoctorProfileActivity.class);
                startActivity(special_Intent);
            }
        });

        mPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my_Intent = new Intent(rootView.getContext(),Doctor_ProfileActivity.class);
                startActivity(my_Intent);
            }
        });

        mRosterPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rosterPlan_Intent = new Intent(rootView.getContext(),Doctor_RosterPlanActivity.class);
                startActivity(rosterPlan_Intent);
            }
        });

        mEditRosterPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editRosterPlan_Intent = new Intent(rootView.getContext(),Doctor_EditRosterPlanActivity.class);
                startActivity(editRosterPlan_Intent);
            }
        });

        mEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editProfile_Intent = new Intent(rootView.getContext(),Doctor_EditProfileActivity.class);
                startActivity(editProfile_Intent);
            }
        });
        return rootView;
    }


}
