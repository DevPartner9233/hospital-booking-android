package com.example.aman.hospitalappointy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Doctor_ProfileActivity extends AppCompatActivity {

    private TextView mName, mEmail, mSpecialization, mExperiance, mAge, mContact, mAddress, mEducation;
    private Button mShowRosterPlanButton;
    private Button mEditProfileButton;
    private Toolbar mToolbar;

    private String name,specialization,experiance,education,email,age,contact,address;

    private DatabaseReference mDoctorDatabase = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__profile);

        mName = (TextView) findViewById(R.id.doctor_name);
        mSpecialization = (TextView) findViewById(R.id.doctor_specialization);
        mExperiance = (TextView) findViewById(R.id.doctor_experience);
        mEducation = (TextView) findViewById(R.id.doctor_education);
        mEmail = (TextView) findViewById(R.id.doctor_email);
        mAge = (TextView) findViewById(R.id.doctor_age);
        mContact = (TextView) findViewById(R.id.doctor_contact);
        mAddress = (TextView) findViewById(R.id.doctor_address);

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.doctor_profile_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mName = (TextView) findViewById(R.id.doctor_name);

        mShowRosterPlanButton = (Button) findViewById(R.id.show_rosterPlan_button);
        mShowRosterPlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Doctor_ProfileActivity.this,"Show Roster Plan Clicked",Toast.LENGTH_SHORT).show();

                Intent showRoster_Intent = new Intent(Doctor_ProfileActivity.this,Doctor_RosterPlanActivity.class);
                startActivity(showRoster_Intent);

            }
        });

        mEditProfileButton = (Button) findViewById(R.id.edit_profile_button);
        mEditProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Doctor_ProfileActivity.this,"Edit Profile Clicked",Toast.LENGTH_SHORT).show();

                Intent editProfile_Intent = new Intent(Doctor_ProfileActivity.this,Doctor_EditProfileActivity.class);

                editProfile_Intent.putExtra("Name",name);
                editProfile_Intent.putExtra("Specialization",specialization);
                editProfile_Intent.putExtra("Experiance",experiance);
                editProfile_Intent.putExtra("Education",education);
                editProfile_Intent.putExtra("Email",email);
                editProfile_Intent.putExtra("Age",age);
                editProfile_Intent.putExtra("Contact",contact);
                editProfile_Intent.putExtra("Address",address);

                startActivity(editProfile_Intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        mDoctorDatabase.child("Doctor_Details").child(mAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                name = dataSnapshot.child("Name").getValue().toString();
                email = dataSnapshot.child("Email").getValue().toString();
                contact = dataSnapshot.child("Contact").getValue().toString();
                education = dataSnapshot.child("Education").getValue().toString();
                specialization = dataSnapshot.child("Specialization").getValue().toString();
                experiance = dataSnapshot.child("Experiance").getValue().toString();
                age = dataSnapshot.child("Age").getValue().toString();
                address = dataSnapshot.child("Address").getValue().toString();

                mName.setText(name);
                mSpecialization.setText(specialization);
                mExperiance.setText(experiance);
                mEducation.setText(education);
                mEmail.setText(email);
                mAge.setText(age);
                mContact.setText(contact);
                mAddress.setText(address);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
