package edu.rogachova.commands;

import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
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
        try{
            if(input.isEmpty())throw new WrongAmountOfArgumentsException();
            int argument = Integer.parseInt(input);
            int count = collectionManager.countSalary(argument);
            System.out.println("Работников с меньшей зарплатой - " + count);
        }catch(NumberFormatException e){
            System.out.println("начение зарплаты - целое число");
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("У данной команды один аргумент - зарплата");
        }
    }
}
