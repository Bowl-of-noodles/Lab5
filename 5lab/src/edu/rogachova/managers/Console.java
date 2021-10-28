package edu.rogachova.managers;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console
{
    public static void liveMode(CommandManager commandManager, Scanner scanner, CollectionManager collectionManager){
        String income;
        System.out.println("Программа начала работу. Для справки введите help");

        Runtime.getRuntime().addShutdownHook(new Thread("control c shutdown--hook") {
            @Override
            public void run() {
                try
                {
                    collectionManager.save();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });

        do{

            if(!scanner.hasNextLine()){
                throw new NoSuchElementException();
            }
            income = scanner.nextLine();
            try{
                commandManager.executeParsed(income);
            }catch (NoSuchElementException exception) {
                System.out.println("Пользовательский ввод не обнаружен!");
            } catch (IllegalStateException exception) {
                System.out.println("Непредвиденная ошибка!");
            }catch(Exception e){
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }while(! income.equals("exit"));

    }
}
