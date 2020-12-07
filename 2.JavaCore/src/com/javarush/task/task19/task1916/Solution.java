package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
//        String file1 = "D:\\1.txt";
//        String file2 = "D:\\2.txt";
        reader.close();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> toAdd = new ArrayList<>();
        ArrayList<String> toRemove = new ArrayList<>();
        ArrayList<String> isSame = new ArrayList<>();

        BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));

        while (fileReader1.ready()) {
            list1.add(fileReader1.readLine());
        }
        while (fileReader2.ready()) {
            list2.add(fileReader2.readLine());
        }

        fileReader1.close();
        fileReader2.close();

        for (int i = 0; i < list1.size() - 1 ; i++) {
            if (list1.get(i).equals(list2.get(i))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
            } else if (!list2.contains(list1.get(i))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            } else if (list1.get(i).equals(list2.get(i + 1)))
                lines.add(new LineItem(Type.ADDED, list1.get(i)));
        }

     //   System.out.println(1);
 /*       for (String s : list1) {
            if (list2.contains(s))
                isSame.add(s);
            else
                toRemove.add(s);
        }

        for (String s : list2) {
            if (!list1.contains(s))
                toAdd.add(s);
        }
        Type prev = null;
        for (int i = 0, j = 0, k = 0; i < isSame.size() || j < toAdd.size() || k < toRemove.size();i++, j++, k++) {
            if (j < toAdd.size()) {
                lines.add(new LineItem(Type.ADDED, toAdd.get(j)));
            }
            if (i < isSame.size()) {
                lines.add(new LineItem(Type.SAME, isSame.get(i)));
            }
            if (k < toAdd.size()) {
                lines.add(new LineItem(Type.REMOVED, toRemove.get(k)));
            }
        }
        //System.out.println(1);*/
    }

public static enum Type {
    ADDED,        //добавлена новая строка
    REMOVED,      //удалена строка
    SAME          //без изменений
}

public static class LineItem {
    public Type type;
    public String line;

    public LineItem(Type type, String line) {
        this.type = type;
        this.line = line;
    }
}
}
