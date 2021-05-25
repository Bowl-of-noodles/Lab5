package edu.rogachova.data;

public class Address
{
    private String street; //Строка не может быть пустой, Поле не может быть null
    private Location town; //Поле может быть null

    public Address(){

    }

    public Address(String street, Location location){
        this.street = street;
        this.town = location;
    }

    public String getStreet()
    {
        if(street == null){
            return "null";
        }
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public Location getTown()
    {
        return town;
    }

    public void setTown(Location town)
    {
        this.town = town;
    }
}

