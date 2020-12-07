package com.javarush.task.task14.task1408;
//<getDescription() родительского класса> + < Моя страна - Sssss. Я несу N яиц в месяц.> где Sssss - название страны, а N - количество яиц в месяц.

public class UkrainianHen extends Hen{
    public int getCountOfEggsPerMonth() {
        return 40;
    }
    public String getDescription() {
       // <getDescription() родительского класса> + <" Моя страна - Sssss. Я несу N яиц в месяц.">

        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
