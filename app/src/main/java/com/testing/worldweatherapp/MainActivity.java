package com.testing.worldweatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.testing.worldweatherapp.Singleton.getSingleton;

public class MainActivity extends AppCompatActivity {

    public static String lmn;
    public static String lmx;
    public static String dmn;
    public static String dmx;
    public static String imn;
    public static String imx;
    TextView londonMin;
    TextView londonMax;
    TextView delhiMin;
    TextView delhiMax;
    TextView indianaMax;
    TextView indianaMin;

    Singleton main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        londonMin = findViewById(R.id.londonMinTemp);
        londonMax = findViewById(R.id.londonMaxTemp);
        delhiMax = findViewById(R.id.delhiMaxTemp);
        delhiMin = findViewById(R.id.delhiMinTemp);
        indianaMax = findViewById(R.id.indianaMaxTemp);
        indianaMin = findViewById(R.id.indianaMinTemp);

        main = new Singleton();


        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {


//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(API.BASE_URL)
//                        .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
//                        .build();
//
//                API api = retrofit.create(API.class);
//
//                Call<WeatherData> weatherDataCall1 = api.getWeather("London", "c3f5d6c81b96c66c2dbd55ce7c2ba415");
//
//                weatherDataCall1.enqueue(new Callback<WeatherData>() {
//                    @Override
//                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
//                        WeatherData weatherData = response.body();
//
//                        System.out.println("London " + weatherData.getMain().getTemp_max());
//
//                        londonMax.setText(String.valueOf(weatherData.getMain().getTemp_max()));
//                        londonMin.setText(String.valueOf(weatherData.getMain().getTemp_min()));
//
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<WeatherData> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//
//                Call<WeatherData> weatherDataCall2 = api.getWeather("Delhi", "c3f5d6c81b96c66c2dbd55ce7c2ba415");
//
//                weatherDataCall2.enqueue(new Callback<WeatherData>() {
//                    @Override
//                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
//                        WeatherData weatherData = response.body();
//
//                        System.out.println("Delhi " + weatherData.getMain().getTemp_max());
//                        delhiMax.setText(String.valueOf(weatherData.getMain().getTemp_max()));
//                        delhiMin.setText(String.valueOf(weatherData.getMain().getTemp_min()));
//                    }
//
//                    @Override
//                    public void onFailure(Call<WeatherData> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//
//                Call<WeatherData> weatherDataCall3 = api.getWeather("Indiana", "c3f5d6c81b96c66c2dbd55ce7c2ba415");
//
//                weatherDataCall3.enqueue(new Callback<WeatherData>() {
//                    @Override
//                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
//                        WeatherData weatherData = response.body();
//
//                        System.out.println("IND " + weatherData.getMain().getTemp_max());
//                        indianaMax.setText(String.valueOf(weatherData.getMain().getTemp_max()));
//                        indianaMin.setText(String.valueOf(weatherData.getMain().getTemp_min()));
//                    }
//
//                    @Override
//                    public void onFailure(Call<WeatherData> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                });

                WeatherAPI weatherAPI = new WeatherAPI();

                weatherAPI.execute();

                londonMax.setText(lmx);
                londonMin.setText(lmn);

                delhiMin.setText(dmn);
                delhiMax.setText(dmx);

                indianaMin.setText(imn);
                indianaMax.setText(imx);


                handler.postDelayed(this, 10000);

            }
        });


//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(API.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
//                .build();
//
//        API api = retrofit.create(API.class);
//
//        Call<WeatherData> weatherDataCall1 = api.getLondonWeather("London", "c3f5d6c81b96c66c2dbd55ce7c2ba415");
//
//        weatherDataCall1.enqueue(new Callback<WeatherData>() {
//            @Override
//            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
//                WeatherData weatherData = response.body();
//
//                System.out.println("London " + weatherData.getMain().getTemp_max());
//            }
//
//            @Override
//            public void onFailure(Call<WeatherData> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        Call<WeatherData> weatherDataCall2 = api.getLondonWeather("Delhi", "c3f5d6c81b96c66c2dbd55ce7c2ba415");
//
//        weatherDataCall2.enqueue(new Callback<WeatherData>() {
//            @Override
//            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
//                WeatherData weatherData = response.body();
//
//                System.out.println("Delhi " + weatherData.getMain().getTemp_max());
//            }
//
//            @Override
//            public void onFailure(Call<WeatherData> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        Call<WeatherData> weatherDataCall3 = api.getLondonWeather("Indiana", "c3f5d6c81b96c66c2dbd55ce7c2ba415");
//
//        weatherDataCall3.enqueue(new Callback<WeatherData>() {
//            @Override
//            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
//                WeatherData weatherData = response.body();
//
//                System.out.println("IND " + weatherData.getMain().getTemp_max());
//            }
//
//            @Override
//            public void onFailure(Call<WeatherData> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }

    public class WeatherAPI extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(API.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
//                    .build();


            API api = Singleton.getSingleton().getRetrofit().create(API.class);

            Call<WeatherData> weatherDataCall1 = api.getWeather("London", "c3f5d6c81b96c66c2dbd55ce7c2ba415");

            try {
                System.out.println("here4");
                Response<WeatherData> w = weatherDataCall1.execute();
                if (w.isSuccessful()) {
                    WeatherData weatherData = w.body();

                    MainActivity.lmn = String.valueOf(weatherData.getMain().getTemp_min());
                    MainActivity.lmx = String.valueOf(weatherData.getMain().getTemp_max());


//                    londonMax.setText(String.valueOf(weatherData.getMain().getTemp_max()));
//                    londonMin.setText(String.valueOf(weatherData.getMain().getTemp_min()));


                } else {
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

                    MainActivity.dmn = String.valueOf(weatherData.getMain().getTemp_min());
                    MainActivity.dmx = String.valueOf(weatherData.getMain().getTemp_max());

//                    delhiMax.setText(String.valueOf(weatherData.getMain().getTemp_max()));
//                    delhiMin.setText(String.valueOf(weatherData.getMain().getTemp_min()));


                } else {
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

                    MainActivity.imn = String.valueOf(weatherData.getMain().getTemp_min());
                    MainActivity.imx = String.valueOf(weatherData.getMain().getTemp_max());

//                    indianaMax.setText(String.valueOf(weatherData.getMain().getTemp_max()));
//                    indianaMin.setText(String.valueOf(weatherData.getMain().getTemp_min()));


                } else {
                    System.out.println("error with response");
                }

            } catch (IOException e) {
                System.out.println("error with server");
                e.printStackTrace();
            }
            return null;
        }
    }
}
