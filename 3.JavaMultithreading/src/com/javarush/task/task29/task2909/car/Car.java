package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    public static void main(String[] args) {

    }

    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if (date.before(summerEnd) && date.after(summerStart))
            return true;
        else
            return false;
    }
    private boolean canPassengersBeTransferred() {
        if (isDriverAvailable() && fuel > 0)
            return true;
        else
            return false;
    }

    public static Car create(int type, int numberOfPassengers) {
        switch (type) {
            case Car.CABRIOLET:
                return new Cabriolet(numberOfPassengers);
            case Car.SEDAN:
                return new Sedan(numberOfPassengers);
            case Car.TRUCK:
                return new Truck(numberOfPassengers);
            default:
                return null;
        }
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception("NEGATIVE FUEL");
        fuel += numberOfLiters;
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer(date, SummerStart, SummerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length) * summerFuelConsumption;
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {

        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    static protected final int MAX_TRUCK_SPEED = 80;
    static protected final int MAX_SEDAN_SPEED = 120;
    static protected final int MAX_CABRIOLET_SPEED = 90;
    public abstract int getMaxSpeed();
}