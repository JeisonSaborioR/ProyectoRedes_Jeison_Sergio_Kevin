package com.tec.weatherstation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by kzamora on 26/11/2017.
 */

public class WeatherAdapter extends BaseAdapter {
    protected Activity activity;
    private static LayoutInflater inflater = null;

    protected ArrayList<WeatherLog> originalItems;
    protected ArrayList<WeatherLog> filteredItems;

    public WeatherAdapter(Activity activity, ArrayList<WeatherLog> items) {
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.originalItems = items;
        this.filteredItems = items;
    }

    @Override
    public int getCount() {
        return filteredItems.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            v = inflater.inflate(R.layout.item_list, null);
        }
        final WeatherLog log = filteredItems.get(position);


        TextView lblTempC = (TextView) v.findViewById(R.id.lblTempC);
        TextView lblstationName = (TextView) v.findViewById(R.id.lblStationName);
        TextView lblDate = (TextView) v.findViewById(R.id.lblDate);

        Double a = Double.parseDouble(log.getTemperatureC());

        DecimalFormat oneDigit = new DecimalFormat("#,##0.0");

        Long c = Long.parseLong(log.getDate());
        Date date = new Date(c);
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");
        String reportDate = df.format(date);


        lblTempC.setText(oneDigit.format(a) + " °C");
        lblstationName.setText(log.getIdStation());
        lblDate.setText(reportDate);

        return v;
    }
}
