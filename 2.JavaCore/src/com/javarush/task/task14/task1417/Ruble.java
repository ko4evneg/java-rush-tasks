package com.javarush.task.task14.task1417;

public class Ruble extends Money {

    public Ruble (double money) {
        super(money);
    }
    @Override
    public String getCurrencyName() {
        return "RUB";
    }
}
