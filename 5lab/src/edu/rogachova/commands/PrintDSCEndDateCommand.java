package edu.rogachova.commands;

import edu.rogachova.exceptions.CollectionIsEmptyException;
import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.CollectionManager;

public class PrintDSCEndDateCommand implements Command
{
    private CollectionManager collectionManager;

    public PrintDSCEndDateCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName()
    {
        return "print_field_descending_end_date";
    }

    @Override
    public String getDescription()
    {
        return "вывести значения поля endDate всех элементов в порядке убывания";
    }

    @Override
    public void execute(String input) throws Exception
    {
        try{
            if(collectionManager.employees.size() == 0) throw new CollectionIsEmptyException();
            if(!input.isEmpty()) throw new WrongAmountOfArgumentsException();
            collectionManager.printDSCEnd();
        }catch(CollectionIsEmptyException e){
            System.out.println("Коллекция пуста. Нет данных для вывода");
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("У команды не должно быть аргументов");
        }
    }
}
