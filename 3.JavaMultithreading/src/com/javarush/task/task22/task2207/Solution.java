package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        String s = "";
        String fileName = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = "D:\\temp_java\\test.txt";// reader.readLine();
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String temp = null;
            while ((temp = fileReader.readLine()) != null){
                s += temp + System.lineSeparator();
            }
            fileReader.close();
        } catch (FileNotFoundException foundException) {
            foundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        s = s.replaceAll("(\\n|\\r\\n)", " ");
        StringBuilder sb = new StringBuilder(s);
        findNext(sb);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {}
        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

    private static void findNext(StringBuilder sb) {
        int nextSpace = sb.indexOf(" ");
        String s;
        if (nextSpace > 0) {
            //take 1st word and remove it from sb
            s = sb.substring(0, nextSpace);
            StringBuilder temp = new StringBuilder(s);
            String reverseS = temp.reverse().toString();
            sb = sb.replace(0, nextSpace + 1,"");
            //extract words left and comparing with reverse 1st word (and adding Pair on match)
            String[] strings = sb.toString().replaceAll("\\s\\s+"," ").trim().split(" ");
            for (String str : strings) {
                if (reverseS.equals(str)) {
                    result.add(new Pair(s, reverseS));
                    sb.replace(sb.indexOf(reverseS), sb.indexOf(reverseS) + reverseS.length(), "");
                    while (sb.indexOf(" ") == 0)
                        sb.replace(0, 1, "");
                    break;
                }
            }
            findNext(sb);
        }
    }
}
