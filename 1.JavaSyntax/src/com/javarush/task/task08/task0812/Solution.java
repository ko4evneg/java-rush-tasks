package com.javarush.task.task08.task0812;

import java.io.IOException;
import java.io.*;
import java.util.*;

/* 
Cамая длинная последовательность
Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

. Программа должна выводить число на экран.
3. В методе main объяви переменную типа List с типом элементов Integer и сразу проинициализируй ee.
4. Программа должна добавлять в коллекцию 10 чисел, согласно условию.
5. Программа должна выводить на экран длину самой длинной последовательности повторяющихся чисел в списке.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int longestSame = 1;
        int longestIndex = 0;
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        //Iterator<Integer> iterator = list.iterator();
        //int longest = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            boolean seq = list.get(i).equals(list.get(i + 1));
            if (seq) {
                int currentLength = 2;
                int j = i + 1;
                while (j < list.size() - 1){
                    if (list.get(j).equals(list.get(j + 1))) {
                        currentLength++;
                        j++;
                        i++;
                    } else
                        break;
                }
                if (currentLength > longestSame) longestSame = currentLength;
            }
        }
        if (longestSame == 0) longestSame++;
        System.out.println(longestSame);
    }
}