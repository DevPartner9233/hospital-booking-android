package com.example.aman.hospitalappointy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Patient_BookAppointmentActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__book_appointment);

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.patient_bookAppointment);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Book Appointment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
