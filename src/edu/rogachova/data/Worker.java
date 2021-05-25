package edu.rogachova.data;

import edu.rogachova.data.Coordinates;
import edu.rogachova.data.Organization;
import edu.rogachova.data.Position;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Random;

import static java.lang.Long.valueOf;

public class Worker
{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double salary; //Поле не может быть null, Значение поля должно быть больше 0
    private java.time.LocalDate startDate; //Поле не может быть null
    private java.time.LocalDate endDate; //Поле может быть null
    private Position position; //Поле может быть null
    private Organization organization; //Поле не может быть null
    private static Long unique = valueOf(11);

    public Worker(String name, Coordinates coordinates,Double salary,java.time.LocalDate startDate, Organization organization){
        this.id = createId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.salary = salary;
        this.startDate = startDate;
        this.organization = organization;
    }

    public Worker(String name, Coordinates coordinates,Double salary,java.time.LocalDate startDate,java.time.LocalDate endDate,Position position, Organization organization){
        this.id = createId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.organization = organization;
    }

    public Worker(){
        this.id = createId();
        this.creationDate = ZonedDateTime.now();
    }

    private Long createId(){
        Random random = new Random();
        return unique + valueOf(random.nextInt(10000));
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if(name == "" || name == " "){
            throw new NullPointerException("Имя отсутствует или не соответсвует норме");
        }
        else{
            this.name = name;
        }
    }

    public Coordinates getCoordinates()
    {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates)
    {
        this.coordinates = coordinates;
    }

    public Double getSalary()
    {
        return salary;
    }

    public void setSalary(Double salary)
    {
        if(salary <= 0){
            throw new InvalidParameterException("Зарплата должна быть неотрицательной");
        }
        else{
            this.salary = salary;
        }
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        if(startDate == null){
            throw new NullPointerException("Поле даты начала обязательно должно быть заполнено");
        }
        else{
            this.startDate = startDate;
        }
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public String getStringEndDate(){
        if(endDate == null){return "null";}
        return endDate.toString();
    }

    public void setEndDate(LocalDate endDate)
    {
        this.endDate = endDate;

    }

    public Position getPosition()
    {
        return position;
    }

    public String getStringPosition(){
        if(position == null){
            return "null";
        }
        else{
            return position.toString();
        }
    }

    public void setPosition(Position position)
    {
        if(position.equals(Position.CLEANER) || position.equals(Position.HUMAN_RESOURCES) || position.equals(Position.LEAD_DEVELOPER)){
            this.position = position;
        }
        else{
            System.out.println("Введенной должности не существует");
        }
    }

    public void setStrPosition(String position)
    {
        if(position.equals(Position.CLEANER.toString())){this.position = Position.CLEANER;}
        else if(position.equals(Position.HUMAN_RESOURCES.toString())){this.position = Position.HUMAN_RESOURCES;}
        else if(position.equals(Position.LEAD_DEVELOPER.toString())){this.position = Position.LEAD_DEVELOPER;}
        else if(position.equals(" ")){}
    }

    public Organization getOrganization()
    {
        return organization;
    }

    public void setOrganization(Organization organization)
    {
        this.organization = organization;
    }

    @Override
    public String toString()
    {
        return  id.toString()+","+ name + ","+coordinates.getX().toString() +
                ","+ coordinates.getY().toString() + ","+creationDate + ","+salary +
                ","+ startDate.toString() + "," +  this.getStringEndDate() + "," + this.getStringPosition() +
                "," + organization.getFullName()+ "," +
                organization.getStringAnnualTurnover() +
                "," + organization.getPostalAddress().getStreet() + ","
                + organization.getPostalAddress().getTown().getX()+ "," + organization.getPostalAddress().getTown().getY() +
                "," + organization.getPostalAddress().getTown().getZ() +  "," + organization.getPostalAddress().getTown().getName();

    }

    public String[] workerToParse(){
        return new String[]{id.toString(), this.name, coordinates.getX().toString(), coordinates.getY().toString(), creationDate.toString(),
        salary.toString(), startDate.toString(), this.getStringEndDate(), this.getStringPosition(), organization.getFullName(),
        organization.getStringAnnualTurnover(), organization.getPostalAddress().getStreet(), organization.getPostalAddress().getTown().getStringX(),
        organization.getPostalAddress().getTown().getStringY(), organization.getPostalAddress().getTown().getStringZ(),
        organization.getPostalAddress().getTown().getName()};
    }


}
