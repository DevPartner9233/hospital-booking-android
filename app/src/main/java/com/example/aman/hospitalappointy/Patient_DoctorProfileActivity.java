package com.example.aman.hospitalappointy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Patient_DoctorProfileActivity extends AppCompatActivity {

    private Button mBookAppointmentBtn;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__doctor_profile);

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.patient_doctorProfile_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Doctor Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mBookAppointmentBtn = (Button) findViewById(R.id.book_appointment_button);
        mBookAppointmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Patient_DoctorProfileActivity.this,"Book Appointment Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
