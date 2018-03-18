package com.example.aman.hospitalappointy;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Patient_DoctorProfileActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mEducation;
    private TextView mSpecialization;
    private TextView mExperience;
    private TextView mContactNo;

    private Button mBookAppointmentBtn;
    private Toolbar mToolbar;

    private Calendar calendar;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__doctor_profile);

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.patient_doctorProfile_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Doctor Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mName = (TextView) findViewById(R.id.patient_doctorProfile_name);
        mSpecialization = (TextView) findViewById(R.id.patient_doctorProfile_specialization);
        mEducation = (TextView) findViewById(R.id.patient_doctorProfile_education);
        mExperience = (TextView) findViewById(R.id.patient_doctorProfile_experiance);
        mContactNo = (TextView) findViewById(R.id.patient_doctorProfile_contact);

        mBookAppointmentBtn = (Button) findViewById(R.id.book_appointment_button);
        mBookAppointmentBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(Patient_DoctorProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        String date = dayOfMonth +"/"+ (month+1) +"/"+ year;
                        Toast.makeText(Patient_DoctorProfileActivity.this, date , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Patient_DoctorProfileActivity.this, Patient_BookAppointmentActivity.class);
                        startActivity(intent);
                    }
                },day,month,year);
                datePickerDialog.updateDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        String name = getIntent().getStringExtra("Name").toString();
        String education = getIntent().getStringExtra("Education").toString();
        String specialization = getIntent().getStringExtra("Specialization").toString();
        String experience = getIntent().getStringExtra("Experiance").toString();
        String contact = getIntent().getStringExtra("Contact").toString();

            mName.setText(name);
            mEducation.setText(education);
            mSpecialization.setText(specialization);
            mExperience.setText(experience);
            mContactNo.setText(contact);
    }
}
