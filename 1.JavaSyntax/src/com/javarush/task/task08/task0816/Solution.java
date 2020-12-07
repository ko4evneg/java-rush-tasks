package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* 
Добрая Зинаида и летние каникулы
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Уилис", dateFormat.parse("APRIL 8 2011"));
        map.put("Джоли", dateFormat.parse("JANUARY 22 2000"));
        map.put("Редклиф", dateFormat.parse("JUNE 29 2002"));
        map.put("Боярский", dateFormat.parse("JULY 11 2010"));
        map.put("Михалков", dateFormat.parse("DECEMBER 21 1990"));
        map.put("Панин", dateFormat.parse("DECEMBER 20 1995"));
        map.put("Лысый", dateFormat.parse("NOVEMBER 17 2015"));
        map.put("Найтли", dateFormat.parse("MAY 3 1980"));
        map.put("Хэнкс", dateFormat.parse("FEBRUARY 2 1985"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Date> entry = iterator.next();
            Date date = entry.getValue();
            if (date.getMonth() == 5 || date.getMonth() == 6 || date.getMonth() == 7)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}
