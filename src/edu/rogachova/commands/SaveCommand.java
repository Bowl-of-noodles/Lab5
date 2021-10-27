package edu.rogachova.commands;

import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.CollectionManager;

public class SaveCommand implements Command
{
    private CollectionManager collectionManager;
    private String argument;

    public SaveCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName()
    {
        return "save";
    }

    @Override
    public String getDescription()
    {
        return "сохраняет коллекцию в файл";
    }

    @Override
    public void execute(String input) throws Exception
    {
        this.argument = input;
        try{
            if(!argument.equals("")){
                throw new WrongAmountOfArgumentsException();
            }
            collectionManager.save();
            System.out.println("Коллекция схранена в файл");
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("У команды не должно быть аргументов");
        }
    }
}
