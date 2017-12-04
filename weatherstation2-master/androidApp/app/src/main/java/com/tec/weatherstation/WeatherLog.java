package com.tec.weatherstation;

/**
 * Created by kzamora on 26/11/2017.
 */

public class WeatherLog {
    private String idStation;
    private String altitudeM;
    private String altitudeFt;
    private String pressure;
    private String temperatureC;
    private String temperatureF;
    private String humidity;
    private String light;
    private String winddir;
    private String windspeedmph;
    private String rain;
    private String dailyRain;
    private String date;

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    public String getAltitudeM() {
        return altitudeM;
    }

    public void setAltitudeM(String altitudeM) {
        this.altitudeM = altitudeM;
    }

    public String getAltitudeFt() {
        return altitudeFt;
    }

    public void setAltitudeFt(String altitudeFt) {
        this.altitudeFt = altitudeFt;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(String temperatureC) {
        this.temperatureC = temperatureC;
    }

    public String getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(String temperatureF) {
        this.temperatureF = temperatureF;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getWinddir() {
        return winddir;
    }

    public void setWinddir(String winddir) {
        this.winddir = winddir;
    }

    public String getWindspeedmph() {
        return windspeedmph;
    }

    public void setWindspeedmph(String windspeedmph) {
        this.windspeedmph = windspeedmph;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getDailyRain() {
        return dailyRain;
    }

    public void setDailyRain(String dailyRain) {
        this.dailyRain = dailyRain;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeatherLog(String idStation, String altitudeM, String altitudeFt, String pressure, String temperatureC, String temperatureF, String humidity, String light, String winddir, String windspeedmph, String rain, String dailyRain, String date) {
        this.idStation = idStation;
        this.altitudeM = altitudeM;
        this.altitudeFt = altitudeFt;
        this.pressure = pressure;
        this.temperatureC = temperatureC;
        this.temperatureF = temperatureF;
        this.humidity = humidity;
        this.light = light;
        this.winddir = winddir;
        this.windspeedmph = windspeedmph;
        this.rain = rain;
        this.dailyRain = dailyRain;
        this.date = date;
    }

    @Override
    public String toString() {
        return "WeatherLog{" +
                "idStation='" + idStation + '\'' +
                ", altitudeM='" + altitudeM + '\'' +
                ", altitudeFt='" + altitudeFt + '\'' +
                ", pressure='" + pressure + '\'' +
                ", temperatureC='" + temperatureC + '\'' +
                ", temperatureF='" + temperatureF + '\'' +
                ", humidity='" + humidity + '\'' +
                ", light='" + light + '\'' +
                ", winddir='" + winddir + '\'' +
                ", windspeedmph='" + windspeedmph + '\'' +
                ", rain='" + rain + '\'' +
                ", dailyRain='" + dailyRain + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
