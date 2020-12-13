package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.spec.ECField;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties props = new Properties();
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
        try {
            if (fileExtension.equals("xml")) {
                props.loadFromXML(new BufferedInputStream(new FileInputStream(fileName)));
            } else
                props.load(new BufferedInputStream(new FileInputStream(fileName)));
        } catch (Exception e) {

        }

        return props;
    }
}
