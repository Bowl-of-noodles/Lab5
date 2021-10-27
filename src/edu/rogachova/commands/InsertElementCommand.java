package edu.rogachova.commands;

import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.Asker;
import edu.rogachova.managers.CollectionManager;
import edu.rogachova.model.Worker;

import java.util.Scanner;

public class InsertElementCommand implements Command
{
    private String argument;
    private CollectionManager collectionManager;
    private Scanner scanner;

    public InsertElementCommand(CollectionManager collectionManager, Scanner scanner){
        this.collectionManager = collectionManager;
        this.scanner = scanner;
    }

    @Override
    public String getName()
    {
        return "insert";
    }

    @Override
    public String getDescription()
    {
        return "добавляет новый элемент с заданным ключом";
    }

    @Override
    public void execute(String input) throws Exception
    {
        this.argument = input;
        try{
            if(!argument.equals("")){
                throw new WrongAmountOfArgumentsException();
            }
            Asker asker = new Asker(scanner, collectionManager.getNextId());
            Worker worker = asker.createWorker();
            collectionManager.add(worker);
            System.out.println("Новый элемент добавлен");
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("Введите комнаду insert без аргументов, затем следуйте указаниям.");
        }
    }
}
