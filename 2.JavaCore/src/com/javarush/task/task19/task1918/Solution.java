package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    private static ArrayList<Tag> openTags = new ArrayList<>();
    private static ArrayList<Tag> closeTags = new ArrayList<>();
    private static TreeMap<Integer, String> resultTags = new TreeMap<>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        StringBuilder input = new StringBuilder("");
        String tagName = args[0];
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName));) {
            while (fileReader.ready())
                if (!input.toString().equals(""))
                    input.append(System.lineSeparator()).append(fileReader.readLine());
                else
                    input.append(fileReader.readLine());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        String in = input.toString().replaceAll("[\\r\\n|\\n]", "");
        Pattern open = Pattern.compile("<[^\\/][^<]*>");
        Pattern close = Pattern.compile("<\\/[^<]*>");
        Matcher openMatcher = open.matcher(in);
        Matcher closeMatcher = close.matcher(in);

        //looking for next match
        while (openMatcher.find())
            openTags.add(new Tag(openMatcher.start(), openMatcher.end() - 1, openMatcher.group()));
        while (closeMatcher.find())
            closeTags.add(new Tag(closeMatcher.start(), closeMatcher.end() - 1, closeMatcher.group()));

        getAllTags(in, tagName);

        for (Map.Entry entry : resultTags.entrySet()) {
            System.out.println(entry.getValue());
        }

    }

    //Build all tags list
    private static void getAllTags(String input, String tagName) {
        Iterator<Tag> itr = closeTags.iterator();

        while (itr.hasNext()) {
            Tag tagB = itr.next();
            if (!tagB.name.equals("/" + tagName)) {
                itr.remove();
                continue;
            }

            for (int j = openTags.size() - 1; j >= 0; j--) {
                Tag tagA = openTags.get(j);
                if (tagA.endIndex < tagB.startIndex && tagB.name.equals("/" + tagA.name)) {
                    itr.remove();
                    openTags.remove(tagA);
                    String tagString = input.substring(tagA.startIndex, tagB.endIndex + 1);
                    resultTags.put(tagA.startIndex, tagString);
                    break;
                }
            }
        }
    }

    private static class Tag implements Comparable<Tag> {
        int startIndex;
        int endIndex;
        String name;

        public Tag(int startIndex, int endIndex, String name) {
            String tagPart = name.contains(" ") ? name.split(" ")[0] : name.substring(0, name.length() - 1);
            this.name = tagPart.substring(1, tagPart.length());
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public String toString() {
            return String.format("%-8s (%d-%d)", name, startIndex, endIndex);
        }

        @Override
        public int compareTo(Tag o) {
            return this.startIndex < o.startIndex ? -1 : this.startIndex > o.startIndex ? 1 : 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tag tag = (Tag) o;

            if (startIndex != tag.startIndex) return false;
            if (endIndex != tag.endIndex) return false;
            return name != null ? name.equals(tag.name) : tag.name == null;
        }

        @Override
        public int hashCode() {
            int result = startIndex;
            result = 31 * result + endIndex;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}
