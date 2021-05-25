package edu.rogachova.exceptions;

public class TooManyArgumentsException extends Exception
{
    public TooManyArgumentsException(){
        super("Слишком много аргументов");
    }
}
