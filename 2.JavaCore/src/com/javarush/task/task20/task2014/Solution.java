package com.javarush.task.task20.task2014;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
        Solution toSerial = new Solution(4);
        Solution fromSerial;
        System.out.println(toSerial);
        ObjectOutputStream out = null;
        ObjectInputStream in;
        try {
            if (Files.exists(Paths.get("D:\\temp_java\\class.save")))
                Files.delete(Paths.get("D:\\temp_java\\class.save"));
            out = new ObjectOutputStream(new FileOutputStream((Files.createFile(Paths.get("D:\\temp_java\\class.save"))).toFile()));
            out.writeObject(toSerial);
            out.flush();
            out.close();
            Thread.sleep(1000);
            in = new ObjectInputStream(new FileInputStream(new File("D:\\temp_java\\class.save")));
            fromSerial = (Solution) in.readObject();
            System.out.println(fromSerial);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
