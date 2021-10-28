package edu.rogachova.commands;

import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.Asker;
import edu.rogachova.managers.CollectionManager;
import edu.rogachova.model.Worker;

import java.util.Scanner;

public class ReplaceLowerKeyCommand implements Command
{
    private CollectionManager collectionManager;
    private String argument;
    private Scanner scanner;

    public ReplaceLowerKeyCommand(CollectionManager collectionManager, Scanner scanner){
        this.collectionManager = collectionManager;
        this.scanner = scanner;
    }

    @Override
    public String getName()
    {
        return "replace_if_lower";
    }

    @Override
    public String getDescription()
    {
        return "заменить значение по ключу, если новое значение меньше старого";
    }

    @Override
    public void execute(String input) throws Exception
    {
        try
        {
            Long argument = Long.parseLong(input);
            Worker workerInColl = collectionManager.getById(argument);
            if(!collectionManager.employees.containsKey(workerInColl.getId()))
            {
                throw new Exception("Элемента с таким индексом не существует!");
            }
            Asker asker = new Asker(scanner,collectionManager.getNextId());
            Worker worker = asker.createWorker();
            if(workerInColl.getId()-worker.getId() < 0){
                collectionManager.employees.put(argument, worker);
            }
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("У команды один аргумент - ключ работника");
        }
    }
}
