package edu.rogachova;

import edu.rogachova.data.Worker;
import edu.rogachova.managers.FileManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args)
    {
        LinkedHashMap<Integer, Worker> workCollection = new LinkedHashMap<>();
        FileManager fm = new FileManager(workCollection,"C:/Users/Dasha/Desktop/Projects/file.csv");
        //FileManager fm = new FileManager(workCollection,"/home/s316988/Lab5/file.csv");
        fm.readFile();
        workCollection = fm.getWorkCollection();

        Set set = workCollection.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry item = (Map.Entry) iterator.next();
            System.out.println("Key = " + item.getKey() + " Value = " + item.getValue());
        }

        fm.writeToFile("C:/Users/Dasha/Desktop/Projects/result.csv", workCollection);
    }


}
