package com.example.aman.hospitalappointy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Doctor_RosterPlanActivity extends AppCompatActivity {

    private ImageView mEditRosterPlan;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__roster_plan);

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.doctor_rosterPlan_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Roster Plan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mEditRosterPlan = (ImageView) findViewById(R.id.doctor_rosterPlan_ImageView);
        mEditRosterPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent editRoster_Intent = new Intent(Doctor_RosterPlanActivity.this,Doctor_EditRosterPlanActivity.class);
                startActivity(editRoster_Intent);


                //Toast.makeText(Doctor_RosterPlanActivity.this,"Edit Roster Plan",Toast.LENGTH_LONG).show();
            }
        });
    }
}
