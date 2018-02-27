package com.example.aman.hospitalappointy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Doctor_ProfileActivity extends AppCompatActivity {

    private Button mShowRosterPlanButton;
    private Button mEditProfileButton;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__profile);

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.doctor_profile_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
    }
}
