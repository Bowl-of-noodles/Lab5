package edu.rogachova.managers;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console
{
    public static void liveMode(CommandManager commandManager, Scanner scanner){
        String income;
        System.out.println("Программа начала работу. Для справки введите help");
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
