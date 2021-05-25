package edu.rogachova.commands;

public class Command
{
    public String name;
    public String description;


    public boolean execute(){
        return true;
    }

    public String showDescription(){
        return "Описание команды";
    }

}
