package edu.rogachova.commands;

import edu.rogachova.exceptions.WrongAmountOfArgumentsException;
import edu.rogachova.managers.CommandManager;

public class HelpCommand implements Command
{
    CommandManager commandManager;
    private String argument;

    public HelpCommand(CommandManager commandManager){
        this.commandManager = commandManager;
    }

    @Override
    public String getName()
    {
        return "help";
    }

    @Override
    public String getDescription()
    {
        return "выводит инфо о достуных командах";
    }

    @Override
    public void execute(String input) throws Exception
    {
        this.argument = input;

        try{
            if(!argument.equals("")){
                throw new WrongAmountOfArgumentsException();
            }
        System.out.println(commandManager.getDescriptions());
        }catch(WrongAmountOfArgumentsException e){
            System.out.println("У команды не должно быть аргументов");
        }
    }
}
