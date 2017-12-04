package com.tec.weatherstation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailsWeatherLog extends AppCompatActivity {
    WeatherLog selectedLog;

    TextView lblDate;
    TextView lblTempC;
    TextView lblTempF;
    TextView lblAltitudeM;
    TextView lblPressure;
    TextView lblHumidity;
    TextView lblLight;
    TextView lblWinDir;
    TextView lblWinSpeed;
    TextView lblRain;
    TextView lblDailyRain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_weather_log);

        selectedLog = Sender.getData();

        setTitle(selectedLog.getIdStation());

        lblDate = (TextView) findViewById(R.id.lblDate);
        lblTempC = (TextView) findViewById(R.id.lblTempC);
        lblTempF = (TextView) findViewById(R.id.lblTempF);
        lblAltitudeM = (TextView) findViewById(R.id.lblAltitudeM);
        lblPressure = (TextView) findViewById(R.id.lblPressure);
        lblHumidity = (TextView) findViewById(R.id.lblHumidity);
        lblLight = (TextView) findViewById(R.id.lblLight);
        lblWinDir = (TextView) findViewById(R.id.lblWinDir);
        lblWinSpeed = (TextView) findViewById(R.id.lblWinSpeed);
        lblRain = (TextView) findViewById(R.id.lblRain);
        lblDailyRain = (TextView) findViewById(R.id.lblDailyRain);
        //Toast.makeText(this, selectedLog.toString(), Toast.LENGTH_LONG).show();
        setInfo();
    }

    public void setInfo() {
        Double tempC = Double.parseDouble(selectedLog.getTemperatureC());
        Double tempF = Double.parseDouble(selectedLog.getTemperatureF());

        DecimalFormat oneDigit = new DecimalFormat("#,##0.0");

        Long c = Long.parseLong(selectedLog.getDate());
        Date date = new Date(c);
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");
        String reportDate = df.format(date);

        lblDate.setText(reportDate);
        lblTempC.setText(oneDigit.format(tempC) + " °C");
        lblTempF.setText(oneDigit.format(tempF) + " °F");
        lblAltitudeM.setText(selectedLog.getAltitudeM() + " m");
        lblPressure.setText(selectedLog.getPressure() + " Pa");
        lblHumidity.setText(selectedLog.getHumidity() + "%");
        lblLight.setText(selectedLog.getLight() + " lx");
        lblWinDir.setText(selectedLog.getWinddir() + "°");
        lblWinSpeed.setText(selectedLog.getWindspeedmph() + " mph");
        lblRain.setText(selectedLog.getRain() + " mm");
        lblDailyRain.setText(selectedLog.getDailyRain() + " mm");
    }
}
