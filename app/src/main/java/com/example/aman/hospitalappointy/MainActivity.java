package com.example.aman.hospitalappointy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.drm.DrmStore;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigationView;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Fragment_SectionPagerAdapter mFragment_SectionPagerAdapter;

    //Firebase Auth
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Hospital Appointy");

        //DrawerLayout and ToggleButton
        mDrawerLayout = findViewById(R.id.main_drawerLayout);
        mToggle = new ActionBarDrawerToggle(MainActivity.this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //NavigationView
        mNavigationView = (NavigationView) findViewById(R.id.main_nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        //TabLayout , SectionPagerAdapter & ViewPager
        mViewPager = (ViewPager) findViewById(R.id.main_ViewPager);
        mFragment_SectionPagerAdapter = new Fragment_SectionPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mFragment_SectionPagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.main_tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in  or not
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser == null){
            //Disable Navigation item (Log Out)
            Menu menuNav = mNavigationView.getMenu();
            MenuItem nav_logOut = menuNav.findItem(R.id.nav_logout);
            nav_logOut.setEnabled(false);
            Toast.makeText(getBaseContext(),"User is Not Logged In ",Toast.LENGTH_LONG).show();

        }else {

            //Disable Navigation item (Login)
            Menu menuNav = mNavigationView.getMenu();
            MenuItem nav_logIn = menuNav.findItem(R.id.nav_login);
            nav_logIn.setEnabled(false);

            Toast.makeText(getBaseContext(),"User is Logged In ",Toast.LENGTH_LONG).show();

            //Enable Navigation item (Log Out)
            MenuItem nav_logOut = menuNav.findItem(R.id.nav_logout);
            nav_logOut.setEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.nav_home:
                Toast.makeText(getBaseContext(),"Home Clicked",Toast.LENGTH_LONG).show();
                break;

            case R.id.nav_showAppointment:
                Toast.makeText(getBaseContext(),"Show Appointment Clicked",Toast.LENGTH_LONG).show();
                break;

            case R.id.nav_login:
                Intent login_Intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login_Intent);
                break;

            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();

                //Enabling Navigation item (Login) which is disabled during onStart
                Menu menuNav = mNavigationView.getMenu();
                MenuItem nav_logIn = menuNav.findItem(R.id.nav_login);
                nav_logIn.setEnabled(true);

                Toast.makeText(getBaseContext(),"Successfully Logged Out",Toast.LENGTH_LONG).show();

               //Disabling Navigation item (Log Out)
                MenuItem nav_logOut = menuNav.findItem(R.id.nav_logout);
                nav_logOut.setEnabled(false);
                break;

            case R.id.nav_helps:
                Toast.makeText(getBaseContext(),"Help Clicked",Toast.LENGTH_LONG).show();
                break;

            case R.id.nav_feedback:
                Toast.makeText(getBaseContext(),"Feedback Clicked",Toast.LENGTH_LONG).show();
                break;

            case R.id.nav_aboutus:
                Toast.makeText(getBaseContext(),"About Us Clicked",Toast.LENGTH_LONG).show();
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
