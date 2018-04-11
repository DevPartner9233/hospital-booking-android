package com.example.aman.hospitalappointy;

import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Doctor_EditProfileActivity extends AppCompatActivity {

    private TextView mName, mEmail, mSpecialization, mExperiance, mAge, mContact, mAddress, mEducation;
    private Toolbar mToolbar;

    private String name,specialization,experiance,education,email,age,contact,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__edit_profile);

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.doctor_editProfile_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Edit Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mName = (TextView) findViewById(R.id.edit_doctor_name);
        mSpecialization = (TextView) findViewById(R.id.edit_doctor_specialization);
        mExperiance = (TextView) findViewById(R.id.edit_doctor_experiance);
        mEducation = (TextView) findViewById(R.id.edit_doctor_education);
        mEmail = (TextView) findViewById(R.id.edit_doctor_email);
        mAge = (TextView) findViewById(R.id.edit_doctor_age);
        mContact = (TextView) findViewById(R.id.edit_doctor_contact);
        mAddress = (TextView) findViewById(R.id.edit_doctor_address);

        name = getIntent().getStringExtra("Name").toString();
        specialization = getIntent().getStringExtra("Specialization").toString();
        experiance = getIntent().getStringExtra("Experiance").toString();
        education = getIntent().getStringExtra("Education").toString();
        email = getIntent().getStringExtra("Email").toString();
        age = getIntent().getStringExtra("Age").toString();
        contact = getIntent().getStringExtra("Contact").toString();
        address = getIntent().getStringExtra("Address").toString();


        mName.setText(name);
        mSpecialization.setText(specialization);
        mExperiance.setText(experiance);
        mEducation.setText(education);
        mEmail.setText(email);
        mAge.setText(age);
        mContact.setText(contact);
        mAddress.setText(address);
    }

    public void update(View view){

        switch (view.getId()){
            case R.id.edit_experiance:
                Toast.makeText(this, "Experience", Toast.LENGTH_SHORT).show();
                alertDialog(experiance);
                break;

            case R.id.edit_education:
                Toast.makeText(this, "Education", Toast.LENGTH_SHORT).show();
                alertDialog(education);
                break;
            case R.id.edit_address:
                Toast.makeText(this, "Address", Toast.LENGTH_SHORT).show();
                alertDialog(address);
                break;
            case R.id.edit_age:
                Toast.makeText(this, "age", Toast.LENGTH_SHORT).show();
                alertDialog(age);
                break;
            case R.id.edit_contact:
                Toast.makeText(this, "contact", Toast.LENGTH_SHORT).show();
                alertDialog(contact);
                break;

            default:
                break;
        }

    }

    private void alertDialog(String text){

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = getLayoutInflater().inflate(R.layout.udate_dialog, null);

        EditText text1 = (EditText) view.findViewById(R.id.editText);
        Button updateButton = (Button) view.findViewById(R.id.update_button);
        Button cancelButton = (Button) view.findViewById(R.id.cancel_button);

        text1.setText(text, TextView.BufferType.EDITABLE);



        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Doctor_EditProfileActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Doctor_EditProfileActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

//        updateDetail.setText(text, TextView.BufferType.EDITABLE);

        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
