package com.javarush.task.task17.task1703;

import java.util.ArrayList;
import java.util.List;

/* 
Синхронизированные заметки
*/

public class Solution {

    public static void main(String[] args) {
        Note crap1 = new Note();
        Note crap2 = new Note();
        Thread t1 = new Thread(crap1);
        Thread t2 = new Thread(crap2);
        t1.start();
        t2.start();
    }

    public static class Note implements Runnable {

        public final List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            synchronized (notes) {
                notes.add(index, note);
            }
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            String note;
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            synchronized (notes) {
                note = notes.remove(index);
            }
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }

        public void run() {
            this.addNote(0, "1");

        }
    }

}
