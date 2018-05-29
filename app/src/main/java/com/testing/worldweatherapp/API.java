package com.testing.worldweatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    @GET("weather")
    Call<WeatherData> getWeather(@Query("q") String cityname, @Query("appid") String key);

}
