package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
            properties.list(System.out);

            properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
            properties.list(System.out);

            properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
            properties.list(System.out);
        } catch (Exception e) {
            System.out.println("la exceptione");
        }
    }

    public Properties getProperties(String fileName) {
        Properties props = new Properties();
        try {
            if (fileName.endsWith(".xml")) {
                props.loadFromXML(new BufferedInputStream(new FileInputStream(fileName)));
            } else
                props.load(new BufferedInputStream(new FileInputStream(fileName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }
}
