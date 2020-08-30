package com.example.localb2bapp;

public class Farmer {
    private String name;
    private String phoneNo;
    private String ekrishi;

    public Farmer(){}

    public Farmer(String name, String phoneNo, String ekrishi )
    {
        this.name=name;
        this.phoneNo=phoneNo;
        this.ekrishi = ekrishi;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    public String getEkrishi ()
    {
        return ekrishi;
    }
}
