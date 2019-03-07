package org.bt.javashop.controller;

import java.io.*;

public class FileController implements DatabaseController {

    private String database;

    public FileController(String database){
        this.database = database;
    }

    public void writeData(Object data){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.database));) {

            oos.writeObject(data);
            oos.flush();
            System.out.println("Update successful");

        }
        catch (IOException ioExcep){
            System.out.println("Error saving");
        }
    }

    public Object readData(){
        Object data = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.database));) {
            data = ois.readObject();
        }
        catch (IOException | ClassNotFoundException ioExcep){
            System.out.println("Error loading");
            ioExcep.printStackTrace();
        }
        return data;
    }
}

