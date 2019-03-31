package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = cbr.readLine();
            if (line.equals(Planet.EARTH)) {
                // earth
                thePlanet = Earth.getInstance();
            } else if (line.equals(Planet.SUN)) {
                // sun
                thePlanet = Sun.getInstance();
            } else if (line.equals(Planet.MOON)) {
                // moon
                thePlanet = Moon.getInstance();
            } else {
                thePlanet = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
