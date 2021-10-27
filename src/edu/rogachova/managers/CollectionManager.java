package edu.rogachova.managers;

import edu.rogachova.model.Coordinates;
import edu.rogachova.model.Worker;
import java.io.IOException;
import java.rmi.AccessException;
import java.time.*;
import java.util.*;

public class CollectionManager
{

    public HashMap<Long, Worker> employees = new HashMap<>();
    private String type;
    private Date initDate;

    protected Integer nextId;
    protected long nextKey;
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) throws AccessException{
        this.fileManager = fileManager;
        employees = fileManager.readFile();
        nextKey = getNextKey();
        setNextId();
        initDate = new Date();
        type = employees.getClass().getSimpleName();
    }

    private long getNextKey(){
        return (long)(employees.size()+1);
    }

    private void setNextId(){
        List<Integer> ids = new ArrayList<>();
        for (Map.Entry<Long, Worker> w : employees.entrySet()) {
            ids.add(w.getValue().getId());
        }

        this.nextId = Collections.max(ids) + 1;
    }

    public Integer getNextId(){
        return nextId++;
    }

    public Date getInitDate(){
        return initDate;
    }

    public String getCollType(){
        return type;
    }

    public int getSize(){
        return employees.size();
    }


    public void save() throws IOException{
        fileManager.writeToFile(employees);
    }

    public void add(Worker worker){
        employees.put(nextKey, worker);
        nextKey++;
    }

    public Worker getById(long id){
        return employees.get(id);
    }

    public void update(Long id, Worker worker){
        employees.put(id, worker);
    }

    public void clear(){
        employees.clear();
    }

    public void removeByKey(long id){
        employees.remove(id);
    }

    public void show(){
        if(employees.size() == 0){
            System.out.println("В коллекции нет элементов");
        }
        else{
            for(long key : employees.keySet()){
                Worker w = employees.get(key);
                System.out.println(w.toString() + '\n');
            }
        }
    }

    public void removeGreater(Worker worker){
        HashMap <Long, Worker> W = new HashMap<>();
        int count = 0;
        for (Map.Entry<Long, Worker> w : employees.entrySet()) {
            if(w.getValue().compareTo(worker) > 0){
                employees.remove(w.getKey());
                count += 1;
            }
        }
        System.out.println("Удалено "+count+" объектов");
    }




}
