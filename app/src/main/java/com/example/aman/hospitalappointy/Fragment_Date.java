package com.example.aman.hospitalappointy;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Aman on 14-Feb-18.
 */

public class Fragment_Date extends Fragment {

    private TextView mSelectDate;
    private TextView mSelectedDate;

    private Calendar calendar;
    private DatePickerDialog datePickerDialog;

    public Fragment_Date(){
        //Required Empty public constructor otherwise app will crash
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_date,container,false);

        mSelectDate = (TextView) rootView.findViewById(R.id.select_date);
        mSelectedDate = (TextView) rootView.findViewById(R.id.selected_date);

        mSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(rootView.getContext(),"Hello", Toast.LENGTH_SHORT).show();

                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(rootView.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        String date = dayOfMonth +"/"+ (month+1) +"/"+ year;
                        Toast.makeText(rootView.getContext(), date, Toast.LENGTH_SHORT).show();
                        mSelectDate.setText(date);
                        mSelectedDate.setVisibility(rootView.VISIBLE);

                    }
                },day,month,year);
                datePickerDialog.updateDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        return rootView;
    }
}
