package edu.rogachova.commands;

import edu.rogachova.exceptions.CollectionIsEmptyException;
import edu.rogachova.exceptions.WorkerNotFoundException;
import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.CollectionManager;
import edu.rogachova.model.Worker;

public class RemoveKeyCommand implements Command
{
    private CollectionManager collectionManager;
    private String argument;

    public RemoveKeyCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName()
    {
        return "remove_key";
    }

    @Override
    public String getDescription()
    {
        return "удаляет элемент из коллекции по его ключу";
    }

    @Override
    public void execute(String input) throws Exception
    {
        this.argument = input;
        try {
            if (argument.isEmpty()) throw new  WrongAmountOfArgumentsException();
            if (collectionManager.getSize() == 0) throw new CollectionIsEmptyException();
            Long id = Long.parseLong(argument);
            Worker worker = collectionManager.getById(id);
            if (worker == null) throw new WorkerNotFoundException();
            collectionManager.removeByKey(id);
            System.out.println("Работник успешно удален");
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("У команды должен быть один аргумент - key работника");
        }catch(CollectionIsEmptyException e){
            System.out.println("Коллекция пуста");
        }catch(WorkerNotFoundException e){
            System.out.println("Работник с таким key не найден");
        }
    }
}
