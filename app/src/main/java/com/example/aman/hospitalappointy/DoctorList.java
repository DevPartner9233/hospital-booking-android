package com.example.aman.hospitalappointy;

/**
 * Created by Aman on 01-Mar-18.
 */

public class DoctorList{

    private String Name;

    public DoctorList(){

    }

    public DoctorList(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
