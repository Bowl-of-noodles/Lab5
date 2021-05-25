package edu.rogachova.managers;

import com.opencsv.*;
import edu.rogachova.data.*;
import edu.rogachova.exceptions.TooManyArgumentsException;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FileManager
{
    private String path;
    private LinkedHashMap<Integer, Worker> workCollection;

    public FileManager(LinkedHashMap<Integer, Worker> collection, String filePath){
        this.workCollection = collection;
        this.path = filePath;
    }

    public FileManager( String filePath){
        this.path = filePath;
    }

    public void readFile()
    {
        Worker worker;
        Coordinates coord;
        Organization org;
        Address addr;
        Location loc;
        try {
            FileInputStream file = new FileInputStream(path);
            InputStreamReader input = new InputStreamReader(file);
            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader csvReader = new CSVReaderBuilder(input).withCSVParser(parser).withSkipLines(1).build();
            /*String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.println(cell);
                }
            }*/
            List<String[]> allData = csvReader.readAll();
            String name;
            for (String[] row : allData) {
                worker = new Worker();
                coord = new Coordinates();
                org = new Organization();
                addr = new Address();
                loc = new Location();
                for(int i = 0; i < row.length; i++){
                    switch(i){
                        case 0: worker.setName(row[i]);
                            break;
                        case 1: coord.setX(Long.parseLong(row[i]));
                            break;
                        case 2: coord.setY(Long.parseLong(row[i]));
                                worker.setCoordinates(coord);
                            break;
                        case 3: worker.setSalary(Double.parseDouble(row[i]));
                            break;
                        case 4: worker.setStartDate(LocalDate.parse(row[i]));
                            break;
                        case 5: if(!row[i].equals(""))worker.setEndDate(LocalDate.parse(row[i]));
                            break;
                        case 6: worker.setStrPosition(row[i]);
                            break;
                        case 7: org.setFullName(row[i]);
                            break;
                        case 8: if(!row[i].equals("")){org.setAnnualTurnover(Float.parseFloat(row[i]));}
                            break;
                        case 9: if(!row[i].equals("")){addr.setStreet(row[i]);}
                            break;
                        case 10: if(!row[i].equals("")){loc.setX(Double.parseDouble(row[i]));}
                            break;
                        case 11: if(!row[i].equals("")){loc.setY(Integer.valueOf(row[i]));}
                            break;
                        case 12: if(!row[i].equals("")){loc.setZ(Long.parseLong(row[i]));}
                            break;
                        case 13: if(!row[i].equals("")){loc.setName(row[i]);}
                            break;
                        case 14: throw new TooManyArgumentsException();
                        default: throw new NullPointerException("Ошибка в данных в файле");

                    }
                    addr.setTown(loc);
                    org.setPostalAddress(addr);
                    worker.setOrganization(org);
                }
                Random rnd = new Random();
                UniqueKey mykey = new UniqueKey();
                mykey.setCollKey(rnd.nextInt(20));
                workCollection.put(mykey.getCollKey(),worker);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String filePath, LinkedHashMap<Integer, Worker> collection ){
        try
        {
            FileOutputStream fos = new FileOutputStream(filePath);
            OutputStreamWriter output = new OutputStreamWriter(fos);
            CSVWriter writer = new CSVWriter(output,',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);
            List<String[]> data = new ArrayList<>();
            Collection<Worker> writData= collection.values();
            for(Worker worker : writData){
                data.add(worker.workerToParse());
            }
            writer.writeAll(data);
            writer.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public LinkedHashMap<Integer, Worker> getWorkCollection()
    {
        return workCollection;
    }

    public void setWorkCollection(LinkedHashMap<Integer, Worker> workCollection)
    {
        this.workCollection = workCollection;
    }
}

