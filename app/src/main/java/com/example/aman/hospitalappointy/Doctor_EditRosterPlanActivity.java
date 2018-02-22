package com.example.aman.hospitalappointy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Doctor_EditRosterPlanActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__edit_roster_plan);

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.doctor_editRosterPlan_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Edit Roster Plan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
