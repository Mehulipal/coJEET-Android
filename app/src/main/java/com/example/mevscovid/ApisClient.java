package com.example.mevscovid;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amin on 09.10.17.
 */

public class ApisClient {
    public static final String BASE_URL = "http://mehuli.epizy.com/andaman_n_nicobar_islands/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){

        if (retrofit == null){

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }

}
