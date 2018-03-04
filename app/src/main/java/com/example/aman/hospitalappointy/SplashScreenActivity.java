package com.example.aman.hospitalappointy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    private TextView mSplashText;
    private ImageView mSplashLogo;
    private Animation uptodown;
    private Animation downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mSplashText = (TextView) findViewById(R.id.splash_text);
        mSplashLogo = (ImageView) findViewById(R.id.splash_logo);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);


        mSplashText.setAnimation(downtoup);
        mSplashLogo.setAnimation(uptodown);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(5000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally
                {
                    Intent main_Intent= new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(main_Intent);
                }
            }
        };
        thread.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
