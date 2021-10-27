package edu.rogachova.commands;

import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.CollectionManager;

public class ShowCommand implements Command
{
    private CollectionManager collectionManager;
    private String argument;

    public ShowCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName()
    {
        return "show";
    }

    @Override
    public String getDescription()
    {
        return "выводит все элементы коллекции в строковом представлении";
    }

    @Override
    public void execute(String input) throws Exception
    {
        this.argument = input;
        try{
            if(!argument.equals("")){
                throw new WrongAmountOfArgumentsException();
            }
            collectionManager.show();
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("У команды не должно быть аргументов");
        }
    }
}
