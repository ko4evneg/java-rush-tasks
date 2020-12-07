package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import com.javarush.task.task15.task1529.Plane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        if      (s.equals(Planet.MOON)) thePlanet = Moon.getInstance();
        else  if(s.equals(Planet.EARTH)) thePlanet  = Earth.getInstance();
        else  if(s.equals(Planet.SUN)) thePlanet = Sun.getInstance();
        else
            thePlanet = null;

    }

    /*static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader brd = new BufferedReader(new InputStreamReader((System.in)));
        String str = "";
        try {
            str = brd.readLine();
            brd.close();
        } catch (Exception e) {
        }

        if (str.equals(Planet.EARTH))
            thePlanet = Earth.getInstance();
        else if (str.equals(Planet.MOON))
            thePlanet = Moon.getInstance();
        else if (str.equals(Planet.SUN))
            thePlanet = Sun.getInstance();
        else
            thePlanet = null;
    }*/
}
