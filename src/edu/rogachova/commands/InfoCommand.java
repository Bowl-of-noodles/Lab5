package edu.rogachova.commands;

import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.CollectionManager;

public class InfoCommand implements Command
{
    private CollectionManager collectionManager;
    String argument;

    public InfoCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName()
    {
        return "info";
    }

    @Override
    public String getDescription()
    {
        return "выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    @Override
    public void execute(String input) throws Exception
    {
        this.argument = input;

        try{
            if(!argument.equals("")){
                throw new WrongAmountOfArgumentsException();
            }
            System.out.println(
                    "Информация о коллекции: "+"\n" +
                    "Тип коллекции: "+ collectionManager.getCollType() +"\n" +
                    "Дата инициализации: "+ collectionManager.getInitDate() + "\n" +
                    "Количество элементов в коллекции: " + collectionManager.getSize()
            );
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("У команды не должно быть аргументов");
        }
    }
}
