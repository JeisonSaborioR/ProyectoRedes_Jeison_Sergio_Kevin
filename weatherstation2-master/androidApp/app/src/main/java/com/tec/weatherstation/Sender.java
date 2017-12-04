package com.tec.weatherstation;

/**
 * Created by kzamora on 26/11/2017.
 */

public class Sender {
    private static WeatherLog log = null;

    public static WeatherLog getData() {
        return log;
    }

    public static void setData(WeatherLog data) {
        log = data;
    }
}