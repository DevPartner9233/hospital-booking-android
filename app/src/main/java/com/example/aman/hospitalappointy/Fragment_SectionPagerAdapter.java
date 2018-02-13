package com.example.aman.hospitalappointy;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Aman on 14-Feb-18.
 */

public class Fragment_SectionPagerAdapter extends FragmentPagerAdapter{
    public Fragment_SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment_Specialization fragment_specialization = new Fragment_Specialization();
                return  fragment_specialization;

            case 1:
                Fragment_Doctor fragment_doctor = new Fragment_Doctor();
                return fragment_doctor;

            case 2:
                Fragment_Date fragment_date = new Fragment_Date();
                return fragment_date;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "SPECIALIZATION";
            case 1:
                return "DOCTOR";
            case 2:
                return "DATE";

            default:
                return null;
        }
    }
}
