package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args == null || args.length <= 0) return;

        String toDo = args[0];
        switch (toDo) {
            case "-c":
                addPerson(args[1], args[2], args[3]);
                break;
            case "-u":
                updatePerson(args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                delPerson(args[1]);
                break;
            case "-i":
                getPerson(args[1]);
                break;
        }
    }

    private static void addPerson(String name, String sex, String dateText) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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

