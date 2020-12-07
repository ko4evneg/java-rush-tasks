package com.javarush.task.task14.task1417;

public class USD extends Money {

    public USD (double money) {
        super(money);
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
