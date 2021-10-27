package edu.rogachova.commands;

import edu.rogachova.managers.CollectionManager;

public class CountLessSalaryCommand implements Command
{
    private CollectionManager collectionManager;

    public CountLessSalaryCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName()
    {
        return "count_less_than_salary";
    }

    @Override
    public String getDescription()
    {
        return "вывести количество элементов, значение поля salary которых меньше заданного";
    }

    @Override
    public void execute(String input) throws Exception
    {
        /*try{
        int argument = Integer.parseInt(input);
        }catch(){

        }*/
    }
}
