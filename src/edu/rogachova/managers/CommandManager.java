package edu.rogachova.managers;

import edu.rogachova.commands.*;
import edu.rogachova.exceptions.NoCommandFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager
{
    protected HashMap<String, Command> commands = new HashMap<String, Command>();

    public CommandManager(Scanner scanner, CollectionManager collectionManager){
        addCommand(new HelpCommand(this));
        addCommand(new InfoCommand(collectionManager));
        addCommand(new ShowCommand(collectionManager));
        addCommand(new InsertElementCommand(collectionManager, scanner));
        addCommand(new UpdateCommand(collectionManager, scanner));
        addCommand(new RemoveKeyCommand(collectionManager));
        addCommand(new ClearCommand(collectionManager));
        addCommand(new SaveCommand(collectionManager));
        addCommand(new ExecuteScriptCommand(collectionManager, this));
        addCommand(new ExitCommand());
        addCommand(new RemoveGreaterCommand(collectionManager, scanner));
        addCommand(new ReplaceLowerKeyCommand(collectionManager, scanner));
        //addCommand(new RemoveGreaterKeyCommand());
        addCommand(new CountLessSalaryCommand(collectionManager));
        /*addCommand(new FilterStartWithCommand());
        addCommand(new PrintDSCEndDate());*/
    }

    void addCommand(Command command){
        if (commands.containsKey(command.getName()))
        {
            throw new IllegalArgumentException("Данная команда уже существует");
        }
        commands.put(command.getName(), command);
    }

    public void executeParsed(String income){
        String[] userCommand = {"",""};
        try{
            userCommand = (income.trim()+" ").split(" ", 2);
            userCommand[1] = userCommand[1].trim();
            if(!commands.containsKey(userCommand[0])){
                throw new NoCommandFoundException("Команды "+ userCommand[0] + " не существует. Список команд можно вывести с помощью команды \"help\" ");
            }
            commands.get(userCommand[0]).execute(userCommand[1]);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getDescriptions(){
        String descriptions = "";
        for (Map.Entry<String, Command> com : commands.entrySet()) {
            Command command = com.getValue();
            descriptions +=  command.getName() + ": " + command.getDescription() + "\n";
        }
        return descriptions;
    }

}
