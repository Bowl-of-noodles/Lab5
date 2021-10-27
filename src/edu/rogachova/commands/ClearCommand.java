package edu.rogachova.commands;

import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.CollectionManager;

public class ClearCommand implements Command
{
    private CollectionManager collectionManager;
    private String argument;

    public ClearCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName()
    {
        return "clear";
    }

    @Override
    public String getDescription()
    {
        return "очистить коллекцию";
    }

    @Override
    public void execute(String input) throws Exception
    {
        this.argument = input;

        try{
            if(!argument.equals("")){
                throw new WrongAmountOfArgumentsException();
            }
            collectionManager.clear();
            System.out.println("Все элементы коллекции удалены");
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("У команды не должно быть аргументов");
        }
    }
}
