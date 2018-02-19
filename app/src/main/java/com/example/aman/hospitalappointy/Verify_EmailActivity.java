package com.example.aman.hospitalappointy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Verify_EmailActivity extends AppCompatActivity {

    private TextView mEmail;
    private TextView mEmailSent;
    private TextView mEmailVerified;

    private Toolbar mToolbar;
    private Button mVerifyEmailButton;
    private Button mVerifyButton;

    private ProgressDialog mProgress;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify__email);

        // Toolbar
        mToolbar = (Toolbar) findViewById(R.id.verify_email_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Verify Email");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Progress Dialog
        mProgress = new ProgressDialog(this);

        mUser = FirebaseAuth.getInstance().getCurrentUser();

        mEmail = (TextView) findViewById(R.id.verify_email);
        mEmailSent = (TextView) findViewById(R.id.verify_email_sent);
        mEmailVerified =(TextView) findViewById(R.id.verify_email_Verified);

        mEmail.setText(getIntent().getStringExtra("Email"));

        mVerifyButton = (Button) findViewById(R.id.verify_check_button);
        mVerifyEmailButton = (Button) findViewById(R.id.verify_button);

        //Verify Email Button
        mVerifyEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mProgress.setTitle("Verification Process");
                mProgress.setMessage("Please Wait! While We Processing");
                mProgress.show();

                sendVerification();
            }
        });

        //Check Button
        mVerifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkVerification();
            }
        });
    }

    private void sendVerification() {

        mUser.sendEmailVerification().addOnCompleteListener(Verify_EmailActivity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){

                    mProgress.dismiss();

                    String email = getIntent().getStringExtra("Email");
                    mEmailSent.setText("We have sent Email to "+email);
                }
                else {
                    Toast.makeText(Verify_EmailActivity.this,"Failed to sent email verification",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void checkVerification() {

        String user = mUser.getEmail().toString();
        Toast.makeText(Verify_EmailActivity.this,user+mUser.getUid().toString(),Toast.LENGTH_SHORT).show();

        FirebaseAuth.getInstance().addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(mUser.isEmailVerified()){
                    Toast.makeText(Verify_EmailActivity.this,"Verified",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Verify_EmailActivity.this,"Not Verified",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
