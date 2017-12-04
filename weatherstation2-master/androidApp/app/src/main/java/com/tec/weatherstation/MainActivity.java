package com.tec.weatherstation;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String URL_REST = "http://54.218.29.64/getWeatherData/developmentStation/20";
    private ArrayList<WeatherLog> weatherLogList = new ArrayList<>();
    private WeatherAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        servicioREST();
        ListView list = (ListView) findViewById(R.id.weatherListView);
        adapter = new WeatherAdapter(this, weatherLogList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(onListClick);
    }

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            WeatherLog logSelected = (WeatherLog) adapterView.getAdapter().getItem(position);
            Intent i = new Intent(getApplicationContext(), DetailsWeatherLog.class);
            Sender.setData(logSelected);
            startActivity(i);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            servicioREST();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //**********************************************************************************************
    private void servicioREST() {
        // Tarea AsyncTask para ejecutar la solicitud
        new TaskServicioREST().execute(URL_REST);
    }

    public class TaskServicioREST extends AsyncTask<String, Void, String> {
        // La tarea se ejecuta en un thread tomando como parametro el eviado en
        //   AsyncTask.execute()
        @Override
        protected String doInBackground(String... urls) {
            // tomanos el parámetro del execute() y bajamos el contenido
            return loadContentFromNetwork(urls[0]);
        }

        // El resultado de la tarea tiene el archivo gson el cual mostramos
        protected void onPostExecute(String result) {
            weatherLogList.clear();

            JSONObject json = null;
            try {
                json = new JSONObject(result);
                System.out.println(json.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JSONArray arr = null;
            try {
                arr = json.getJSONArray("data");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < arr.length(); i++)
            {
                try {
                    String idStation = arr.getJSONObject(i).getString("idStation");
                    String altitudeM = arr.getJSONObject(i).getString("altitudeM");
                    String altitudeFt = arr.getJSONObject(i).getString("altitudeFt");
                    String pressure = arr.getJSONObject(i).getString("pressure");
                    String temperatureC = arr.getJSONObject(i).getString("temperatureC");
                    String temperatureF = arr.getJSONObject(i).getString("temperatureF");
                    String humidity = arr.getJSONObject(i).getString("humidity");
                    String light = arr.getJSONObject(i).getString("light");
                    String winddir = arr.getJSONObject(i).getString("winddir");
                    String windspeedmph = arr.getJSONObject(i).getString("windspeedmph");
                    String rain = arr.getJSONObject(i).getString("rain");
                    String dailyRain = arr.getJSONObject(i).getString("dailyRain");
                    String date = arr.getJSONObject(i).get("date").toString();

                    WeatherLog wl = new WeatherLog(idStation, altitudeM, altitudeFt, pressure, temperatureC, temperatureF, humidity, light, winddir, windspeedmph, rain, dailyRain, date);
                    System.out.println(wl.toString());
                    weatherLogList.add(wl);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


        // metodo para bajar el contenido
        private String loadContentFromNetwork(String url) {
            try {
                InputStream mInputStream = (InputStream) new URL(url).getContent();
                InputStreamReader mInputStreamReader = new InputStreamReader(mInputStream);
                BufferedReader responseBuffer = new BufferedReader(mInputStreamReader);
                StringBuilder strBuilder = new StringBuilder();
                String line = null;
                while ((line = responseBuffer.readLine()) != null) {
                    strBuilder.append(line);
                }
                return strBuilder.toString();
            }
            catch (Exception e) { }
            return null;
        }
    }
}
