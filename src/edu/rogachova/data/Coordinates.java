package edu.rogachova.data;

public class Coordinates
{
    private Long x; //Поле не может быть null
    private Long y; //Максимальное значение поля: 426, Поле не может быть null

    public Coordinates(){

    }

    public Coordinates(Long x, Long y){
        this.x = x;
        this.y = y;
    }

    public Long getX()
    {
        return x;
    }

    public void setX(Long x)
    {
        this.x = x;
    }

    public Long getY()
    {
        return y;
    }

    public void setY(Long y)
    {
        this.y = y;
    }
}
