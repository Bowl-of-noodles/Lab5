package edu.rogachova.commands;

import edu.rogachova.exceptions.CollectionIsEmptyException;
import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.CollectionManager;

public class FilterStartWithCommand implements Command
{
    private CollectionManager collectionManager;

    public FilterStartWithCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public String getName()
    {
        return "filter_starts_with_name";
    }

    @Override
    public String getDescription()
    {
        return "вывести элементы, значение поля name которых начинается с заданной подстроки";
    }

    @Override
    public void execute(String input) throws Exception
    {
        try
        {
            if(collectionManager.employees.size() == 0){
                throw new CollectionIsEmptyException();
            }
            if (input.isEmpty()) throw new WrongAmountOfArgumentsException();
            String name = input;
            boolean wasPrint = collectionManager.startWith(name);
            if(!wasPrint){
                System.out.println("Нет работников с именем, начинающимся на " + name);
            }
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("введите подстроку для поиска");
        }catch(CollectionIsEmptyException e){
            System.out.println("Коллекция пуста. Нечего выводить");
        }
    }
}
