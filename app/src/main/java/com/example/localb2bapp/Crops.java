package com.example.localb2bapp;

public class Crops {
    private String cropType;
    private String rate;
    private String quantity;
    private String phoneNo;

    public Crops(){}

   public Crops(String cropType, String rate,String quantity, String phoneNo)
    {
        this.cropType=cropType;
        this.rate=rate;
        this.quantity=quantity;
        this.phoneNo=phoneNo;

    }

    public String getCropType()
    {
        return cropType;
    }
    public String getRate()
    {
     return rate;
    }
    public String getQuantity()
    {
        return  quantity;
    }
    public String getPhoneNo(){return phoneNo;}
}
