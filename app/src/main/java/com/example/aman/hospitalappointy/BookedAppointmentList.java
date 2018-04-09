package com.example.aman.hospitalappointy;

/**
 * Created by Aman on 07-Apr-18.
 */

public class BookedAppointmentList {

    private String Date;
    private String Time;
    private String Doctor_ID;

    public BookedAppointmentList() {
    }

    public BookedAppointmentList(String date, String time, String doctor_ID) {
        this.Date = date;
        this.Time = time;
        this.Doctor_ID = doctor_ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        this.Time = time;
    }

    public String getDoctor_ID() {
        return Doctor_ID;
    }

    public void setDoctor_ID(String doctor_ID) {
        this.Doctor_ID = doctor_ID;
    }
}
