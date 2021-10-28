package edu.rogachova.commands;

import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.CollectionManager;

import java.util.ArrayList;

public class RemoveGreaterKeyCommand implements Command
{
    private CollectionManager collectionManager;

    public RemoveGreaterKeyCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName()
    {
        return "remove_greater_key";
    }

    @Override
    public String getDescription()
    {
        return "удалить из коллекции все элементы, ключ которых превышает заданный";
    }

    @Override
    public void execute(String input)
    {
        long key;
        try{
            if(input.isEmpty()) throw new WrongAmountOfArgumentsException();
            key = Long.parseLong(input);
            collectionManager.removeGreaterKey(key);
        } catch (NumberFormatException e){
            System.out.println("Аргумент команды - key - целое число");
        } catch(WrongAmountOfArgumentsException e){
            System.out.println("У команды должен быть один аргумент - key");
        }
    }
}
