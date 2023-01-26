package com.codecool.dungeoncrawl.ui;


import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Util {

    static final String pathToSaves = "./saves/";

    public static void createSave(String filename, JSONObject save) {
        try {
            File myObj = new File(pathToSaves + filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter(pathToSaves + filename);
            myWriter.write(save.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
