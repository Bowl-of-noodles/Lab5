package edu.rogachova.commands;

import edu.rogachova.exceptions.CollectionIsEmptyException;
import edu.rogachova.exceptions.WorkerNotFoundException;
import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.Asker;
import edu.rogachova.managers.CollectionManager;
import edu.rogachova.model.Worker;

import java.util.Scanner;

public class RemoveGreaterCommand implements Command
{
    private CollectionManager collectionManager;
    private String argument;
    private Scanner scanner;

    public RemoveGreaterCommand(CollectionManager collectionManager, Scanner scanner){
        this.collectionManager  = collectionManager;
        this.scanner = scanner;
    }

    @Override
    public String getName()
    {
        return "remove_greater";
    }

    @Override
    public String getDescription()
    {
        return "удалить из коллекции все элементы, превышающие заданный";
    }

    @Override
    public void execute(String input) throws Exception
    {
        this.argument = input;
        try{
            if (!argument.isEmpty()) throw new WrongAmountOfArgumentsException();
            if (collectionManager.getSize() == 0) throw new CollectionIsEmptyException();
            Asker asker = new Asker(scanner, 0);
            Worker workerToCompareWith = asker.createWorker();
            collectionManager.removeGreater(workerToCompareWith);
        } catch (WrongAmountOfArgumentsException exception) {
            System.out.println("Введите команду без аргументов. Затем следуйте указаниям для создания сравнительного элемента");
        } catch (CollectionIsEmptyException exception) {
            System.out.println("Коллекция пуста");
        }
    }
}
