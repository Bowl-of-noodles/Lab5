package edu.rogachova.commands;

public interface Command
{
    String getName();

    String getDescription();

    void execute(String input) throws Exception;
}
