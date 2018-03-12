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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Doctor_ProfileActivity extends AppCompatActivity {

    private TextView mName;
    private Button mShowRosterPlanButton;
    private Button mEditProfileButton;
    private Toolbar mToolbar;

    private DatabaseReference mDoctorDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__profile);

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
                startActivity(editProfile_Intent);
            }
        });


        //Get the Value from DataBase and set it into Doctor_Profile TextView
        mDoctorDatabase = FirebaseDatabase.getInstance().getReference().child("Doctor_Details").child("qH47alG0gSXa1FSPVogoQ0XYpJI3");
        mDoctorDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("Name").getValue().toString();

                mName.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
