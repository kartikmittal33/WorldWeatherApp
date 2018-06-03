package com.testing.worldweatherapp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singleton {
    private static Singleton instance = null;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    public Singleton() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

    }

    public static Singleton getSingleton() {
        if(instance == null)
            instance = new Singleton();
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
