package com.example.mevscovid;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    /**
     * Created by amin on 09.10.17.
     */

    public class ApiClient {
        public static final String BASE_URL = "https://mehuli-gov.000webhostapp.com/";
        public static Retrofit retrofit = null;

        public static Retrofit getApiClient(){
            if (retrofit == null){
                retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                        addConverterFactory(GsonConverterFactory.create()).build();
            }
            return retrofit;
        }

    }

