package com.reality.escape.partnerapp.Model;

/**
 * Created by JR HARI NANDHA on 18-12-2016.
 */
public class MenuDetails {
    private String name;
    private String gender;
    private String email;
    private String dob;
    private String id;


    public MenuDetails() {
    }

    public MenuDetails(String name, String gender, String email, String dob, String id){
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public String getEmail(){
        return email;
    }
    public String getDob(){
        return dob;
    }
    public String getId(){
        return id;
    }
}
