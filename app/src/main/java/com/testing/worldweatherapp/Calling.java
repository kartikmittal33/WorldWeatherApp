package com.testing.worldweatherapp;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Calling extends IntentService {


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public Calling(String name) {
        super(name);

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        System.out.println("here3");
        Log.d("t", "here3");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        API api = retrofit.create(API.class);

        Call<WeatherData> weatherDataCall1 = api.getWeather("London", "c3f5d6c81b96c66c2dbd55ce7c2ba415");

        try {
            System.out.println("here4");
            Response<WeatherData> w = weatherDataCall1.execute();
            if (w.isSuccessful()) {
                WeatherData weatherData = w.body();

                MainActivity.lmn = String .valueOf(weatherData.getMain().getTemp_min());
                MainActivity.lmx = String .valueOf(weatherData.getMain().getTemp_max());




            }
            else {
                System.out.println("error with response");
            }

        } catch (IOException e) {
            System.out.println("error with server");
            e.printStackTrace();
        }

        Call<WeatherData> weatherDataCall2 = api.getWeather("Delhi", "c3f5d6c81b96c66c2dbd55ce7c2ba415");

        try {

            Response<WeatherData> w = weatherDataCall2.execute();
            if (w.isSuccessful()) {
                WeatherData weatherData = w.body();

                MainActivity.dmn = String .valueOf(weatherData.getMain().getTemp_min());
                MainActivity.dmx = String .valueOf(weatherData.getMain().getTemp_max());


            }
            else {
                System.out.println("error with response");
            }

        } catch (IOException e) {
            System.out.println("error with server");
            e.printStackTrace();
        }

        Call<WeatherData> weatherDataCall3 = api.getWeather("Indiana", "c3f5d6c81b96c66c2dbd55ce7c2ba415");

        try {

            Response<WeatherData> w = weatherDataCall3.execute();
            if (w.isSuccessful()) {
                WeatherData weatherData = w.body();
                        System.out.println("IND " + weatherData.getMain().getTemp_max());

                MainActivity.imn = String .valueOf(weatherData.getMain().getTemp_min());
                MainActivity.imx = String .valueOf(weatherData.getMain().getTemp_max());


            }
            else {
                System.out.println("error with response");
            }

        } catch (IOException e) {
            System.out.println("error with server");
            e.printStackTrace();
        }
    }
}
