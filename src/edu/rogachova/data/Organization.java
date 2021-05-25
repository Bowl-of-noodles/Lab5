package edu.rogachova.data;

import edu.rogachova.data.Address;

import java.security.InvalidParameterException;

public class Organization
{
    private String fullName; //Поле может быть null
    private Float annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    private Address postalAddress; //Поле может быть null

    public Organization(){

    }

    public Organization(String name, Float annualTurnover, Address postalAddress){
        this.fullName = name;
        this.annualTurnover = annualTurnover;
        this.postalAddress = postalAddress;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public Float getAnnualTurnover()
    {
        return annualTurnover;
    }

    public String getStringAnnualTurnover(){
        if(annualTurnover == null){return "null";}
        return annualTurnover.toString();

    }

    public void setAnnualTurnover(Float annualTurnover)
    {
        if( annualTurnover < 0){
            throw new InvalidParameterException("Ежегодный оборот не может быть отрицательным");
        }
        this.annualTurnover = annualTurnover;
    }

    public Address getPostalAddress()
    {
        return postalAddress;
    }

    public String getStringAddress(){
        return postalAddress.toString();
    }

    public void setPostalAddress(Address postalAddress)
    {
        this.postalAddress = postalAddress;
    }
}
