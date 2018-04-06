package com.example.aman.hospitalappointy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class Patient_ShowBookedAppointmentActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__show_booked_appointment);

        mToolbar = (Toolbar) findViewById(R.id.show_bookedAppointment);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Booked Appointments");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
