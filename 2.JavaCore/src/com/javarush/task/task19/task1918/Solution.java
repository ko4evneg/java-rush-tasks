package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    private static ArrayList<Tag> openTags = new ArrayList<>();
    private static ArrayList<Tag> closeTags = new ArrayList<>();

    public static void main(String[] args) {
        String input = ("Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela\n" +
                "</span></b></span><span>Super</span><span>girl</span>").replaceAll("[\\r\\n|\\n]", "");
        Pattern open = Pattern.compile("<[^\\/][^<]*>");
        Pattern close = Pattern.compile("<\\/[^<]*>");
        Matcher openMatcher = open.matcher(input);
        Matcher closeMatcher = close.matcher(input);
        //looking for next match
        while (openMatcher.find())
            openTags.add(new Tag(openMatcher.start(), openMatcher.end() - 1, openMatcher.group()));
        while (closeMatcher.find())
            closeTags.add(new Tag(closeMatcher.start(), closeMatcher.end() - 1, closeMatcher.group()));

        //findNextTag(input);

        for (Tag tag : openTags) {
            System.out.println(tag);
        }
        for (Tag tag : closeTags) {
            System.out.println(tag);
        }


    }

    private static void findNextTag(String input) {
        Tag currentOTag = openTags.remove(0);
        Tag currentCTag;
        for (Tag cTag : closeTags) {
            if (cTag.tag.equals("/" + currentOTag.tag)) {
                Tag closestCTag = cTag;
                //Check OTags left
                for (Tag oTag : openTags) {
                    if (!oTag.tag.equals(currentOTag.tag))
                        continue;
                    if (oTag.startIndex < cTag.startIndex)
                        break;
                    if (oTag.tag.equals(currentOTag.tag)) {
                        currentCTag = cTag;
                        closeTags.remove(closestCTag);
                    }
                }
            }
        }


    }

    private static class Tag implements Comparable<Tag> {
        int startIndex;
        int endIndex;
        String tag;

        public Tag(int startIndex, int endIndex, String tag) {
            String tagPart = tag.contains(" ") ? tag.split(" ")[0] : tag.substring(0, tag.length() - 1);
            this.tag = tagPart.substring(1, tagPart.length());
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public String toString() {
            return String.format("%-8s (%d-%d)", tag, startIndex, endIndex);
        }

        @Override
        public int compareTo(Tag o) {
            return this.startIndex < o.startIndex ? -1 : this.startIndex > o.startIndex ? 1 : 0;
        }
    }


}
