/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.section1.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ui.section1.calculate.inputs.S1Result;

/**
 *
 * @author jamesmurphy
 */
public class S1ResultStore {

    private static final String FILE_NAME = "s1Results.dat";

    private ArrayList<S1Result> results;

    public S1ResultStore() {
        results = new ArrayList<>();
        loadFromFile();
    }

    public void addResult(S1Result r) {
        results.add(r);
        saveToFile();
    }

    public boolean removeLastResult() {
        if (results.isEmpty()) {
            return false;
        }
        results.remove(results.size() - 1);
        saveToFile();
        return true;
    }

    public int getCount() {
        return results.size();

    }

    public ArrayList<S1Result> getAll() {
        return results;
    }

    private void saveToFile() {
        File outFile = new File(FILE_NAME);
        FileOutputStream fStream;
        ObjectOutputStream oStream;
        try {
            fStream = new FileOutputStream(outFile);
            oStream = new ObjectOutputStream(fStream);

            oStream.writeObject(results);
            oStream.close();
            fStream.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File inFile = new File(FILE_NAME);
        
        if (!inFile.exists()) {
            results = new ArrayList<>();
            return;
        }
        FileInputStream fStream;
        ObjectInputStream oStream;

        try {
            fStream = new FileInputStream(inFile);
            oStream = new ObjectInputStream(fStream);

            results = (ArrayList<S1Result>) oStream.readObject();
            oStream.close();
            fStream.close();

            if (results == null) {
                results = new ArrayList<>();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
            results = new ArrayList<>();
        }
    }

}
