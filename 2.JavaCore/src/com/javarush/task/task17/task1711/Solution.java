package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args == null || args.length <= 0) return;

        switch (args[0]) {
            case "-c":
                for (int i = 0; i < args.length - 1; i += 3) {
                    synchronized (allPeople) {
                        addPerson(args[1 + i], args[2 + i], args[3 + i]);
                    }
                }
                break;
            case "-u":
                for (int i = 0; i < args.length - 1; i += 4) {
                    synchronized (allPeople) {
                        updatePerson(args[1 + i], args[2 + i], args[3 + i], args[4 + i]);
                    }
                }
                break;
            case "-d":
                for (int i = 0; i < args.length - 1; i++) {
                    synchronized (allPeople) {
                        delPerson(args[1 + i]);
                    }
                }
                break;
            case "-i":
                for (int i = 0; i < args.length - 1; i++) {
                    synchronized (allPeople) {
                        getPerson(args[1 + i]);
                    }
                }
                break;
        }
    }

    private static void addPerson(String name, String sex, String dateText) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = sdf.parse(dateText);
        Person person;
        if (sex.toLowerCase().equals("м"))
            person = Person.createMale(name, date);
        else
            person = Person.createFemale(name, date);
        allPeople.add(person);
        System.out.println(allPeople.indexOf(person));
    }

    private static void updatePerson(String id, String name, String sex, String dateText) throws ParseException {
        //-u id name sex bd
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = sdf.parse(dateText);
        Person person;
        if (sex.toLowerCase().equals("м"))
            person = Person.createMale(name, date);
        else
            person = Person.createFemale(name, date);
        allPeople.set(Integer.parseInt(id), person);
    }

    private static void delPerson(String id) {
        allPeople.set(Integer.parseInt(id), Person.createFemale(null, null));
        allPeople.get(Integer.parseInt(id)).setSex(null);
    }

    private static void getPerson(String id) {
        System.out.println(allPeople.get(Integer.parseInt(id)));
    }
}
