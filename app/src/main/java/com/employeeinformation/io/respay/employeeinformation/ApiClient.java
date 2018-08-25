package com.employeeinformation.io.respay.employeeinformation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Habib on 24/8/18.
 */

public class ApiClient {
    public static final String URL      = "http://192.168.15.106";
    public static Retrofit RETROFIT     = null;
    public static Retrofit getClient(){
        if(RETROFIT==null){
            OkHttpClient client = new OkHttpClient();
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            RETROFIT = new Retrofit.Builder()
                    .baseUrl(URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return RETROFIT;
    }
}
