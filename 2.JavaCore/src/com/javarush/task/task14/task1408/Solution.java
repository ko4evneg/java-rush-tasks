package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
Методы должны возвращать количество яиц в месяц от данного типа куриц.
7. В каждом из четырех последних классов написать свою реализацию метода getDescription.

Методы должны возвращать строку вида:
<getDescription() родительского класса> + <" Моя страна - Sssss. Я несу N яиц в месяц.">
где Sssss - название страны
где N - количество яиц в месяц

8. В классе HenFactory реализовать метод getHen, который возвращает соответствующую стране породу кур.
6. Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны переопределять метод getDescription родительского класса, таким образом, чтобы возвращаемая ими строка имела вид: <getDescription() родительского класса> + < Моя страна - Sssss. Я несу N яиц в месяц.> где Sssss - название страны, а N - количество яиц в месяц.
7. Метод getHen должен быть реализован в классе HenFactory и должен возвращать тип кур для переданной в него страны.
*/


public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
        //System.out.println(hen.getDescription());
    }

    static class HenFactory implements Country {
        static Hen getHen(String country) {
            Hen hen = null;
            if (country.equals(Country.BELARUS))
                hen = new BelarusianHen();
            if (country.equals(Country.UKRAINE))
                hen = new UkrainianHen();
            if (country.equals(Country.MOLDOVA))
                hen = new MoldovanHen();
            if (country.equals(Country.RUSSIA))
                hen = new RussianHen();
            return hen;
        }
    }

}
