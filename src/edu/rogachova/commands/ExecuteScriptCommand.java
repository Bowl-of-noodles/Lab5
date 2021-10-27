package edu.rogachova.commands;

import edu.rogachova.managers.CollectionManager;
import edu.rogachova.managers.CommandManager;
import edu.rogachova.managers.Console;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExecuteScriptCommand implements Command
{
    CollectionManager collectionManager;
    CommandManager commandManager;

    public ExecuteScriptCommand(CollectionManager collectionManager, CommandManager commandManager){
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
    }

    static Set<String> usedScripts = new HashSet<>();
    @Override
    public String getName()
    {
        return "execute_script";
    }

    @Override
    public String getDescription()
    {
        return "считать и исполнить скрипт из указанного файла.";
    }

    @Override
    public void execute(String input) throws Exception
    {
        String path = input;

        File script = new File(path);

        if(!script.exists()){
            throw new Exception("Такого файла не существует");
        }
        if(!script.canRead()){
            throw new Exception("Нет прав на чтение файла");
        }
        if(usedScripts.contains(path)){
            throw new Exception("Этот скрипт уже выполняется, в целях избежания рекурсии его выполнение запрещено.");
        }

        Scanner fileScanner = new Scanner(new BufferedInputStream(new FileInputStream(script)));

        System.out.println("Скрипт начал выполнятся");
        usedScripts.add(path);
        Console.liveMode(new CommandManager(fileScanner, collectionManager), fileScanner);
        usedScripts.remove(path);
        System.out.println("Выполение скрипта завершено");
    }
}
