package com.example.aman.hospitalappointy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Doctor_EditRosterPlanActivity extends AppCompatActivity {

    private Button mUpdate;
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

        mUpdate = (Button) findViewById(R.id.doctor_editRosterPlan_button);
        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Doctor_EditRosterPlanActivity.this,"Update Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
