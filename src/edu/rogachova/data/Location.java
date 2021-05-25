package edu.rogachova.data;

public class Location
{
    private Double x;
    private Integer y;
    private Long z; //Поле не может быть null
    private String name; //Длина строки не должна быть больше 388, Поле не может быть null

    public Location(){

    }

    public Location(Double x, Integer y, Long z, String name){
        this.x =x;
        this.y =y;
        this.z = z;
        this.name = name;
    }

    public Double getX()
    {
        return x;
    }

    public void setX(Double x)
    {
        this.x = x;
    }

    public String getStringX(){
        if(x == null){
            return "null";
        }
        return x.toString();
    }

    public Integer getY()
    {
        return y;
    }

    public void setY(Integer y)
    {
        this.y = y;
    }

    public String getStringY(){
        if(y == null){
            return "null";
        }
        return y.toString();
    }

    public Long getZ()
    {
        return z;
    }

    public void setZ(Long z)
    {
        this.z = z;
    }

    public String getStringZ(){
        if(z == null){
            return "null";
        }
        return z.toString();
    }

    public String getName()
    {
        if(name == null){
            return "null";
        }
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
