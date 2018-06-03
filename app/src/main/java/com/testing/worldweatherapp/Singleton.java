package com.testing.worldweatherapp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singleton {
    private static Singleton instance = null;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private HttpLoggingInterceptor loggingInterceptor;

    public Singleton() {

        loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        this.okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .client(okHttpClient)
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
