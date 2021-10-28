package edu.rogachova;

import edu.rogachova.commands.SaveCommand;
import edu.rogachova.managers.*;

import java.rmi.AccessException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        //execute_script C:/Users/Dasha/Desktop/Projects/5lab/script.txt

        //String path = "C:/Users/Dasha/Desktop/Projects/5lab/test.xml";

        //String path = "/home/s316988/Lab5/test.xml";
        String path = args[0];
        FileManager fileManager = new FileManager(path);
        CollectionManager collectionManager = null;
        try
        {
            collectionManager = new CollectionManager(fileManager);

        } catch (AccessException e)
        {
            e.printStackTrace();
        }
        CommandManager cm = new CommandManager(new Scanner(System.in), collectionManager);
        Console.liveMode(cm, new Scanner(System.in), collectionManager);

    }
}
