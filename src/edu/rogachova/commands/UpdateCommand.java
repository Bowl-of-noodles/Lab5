package edu.rogachova.commands;

import edu.rogachova.exceptions.CollectionIsEmptyException;
import edu.rogachova.exceptions.WorkerNotFoundException;
import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.Asker;
import edu.rogachova.managers.CollectionManager;
import edu.rogachova.model.Worker;

import java.util.Scanner;

public class UpdateCommand implements Command
{
    private CollectionManager collectionManager;
    private String argument;
    private Scanner scanner;

    public UpdateCommand(CollectionManager collectionManager, Scanner scanner){
        this.collectionManager = collectionManager;
        this.scanner = scanner;
    }

    @Override
    public String getName()
    {
        return "update";
    }

    @Override
    public String getDescription()
    {
        return "обновляет значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public void execute(String input) throws Exception
    {
        this.argument = input;
        if (argument.isEmpty()) throw new WrongAmountOfArgumentsException();
        if (collectionManager.getSize() == 0) throw new CollectionIsEmptyException();

        Long id = Long.parseLong(argument);
        Worker worker = collectionManager.getById(id);
        if (worker == null) throw new WorkerNotFoundException();
        Asker asker = new Asker(scanner, worker.getId());
        asker.askUpdateWorker(worker);
        collectionManager.update(id, worker);
        System.out.println("Данные успешно обновлены");
    }
}
