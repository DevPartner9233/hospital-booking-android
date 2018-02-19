package com.example.aman.hospitalappointy;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class Forgot_PasswordActivity extends AppCompatActivity {

    private TextInputLayout mEmail;
    private Button mResetPassword;
    private Toolbar mToolbar;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);

        mAuth = FirebaseAuth.getInstance();

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.forgot_password_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mEmail = (TextInputLayout) findViewById(R.id.forgot_password_email);

        mResetPassword = (Button) findViewById(R.id.forgot_password_reset_btn);
        mResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailAddress = mEmail.getEditText().getText().toString();

                if(!TextUtils.isEmpty(emailAddress)){
                    mAuth.sendPasswordResetEmail(emailAddress).addOnCompleteListener(Forgot_PasswordActivity.this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Forgot_PasswordActivity.this,"A mail has sent to Your Email",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(Forgot_PasswordActivity.this,"Please Enter Correct Email To Reset Password",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(Forgot_PasswordActivity.this,"Please Enter Email To Reset Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
