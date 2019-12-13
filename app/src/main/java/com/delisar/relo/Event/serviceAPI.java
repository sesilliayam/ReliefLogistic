package com.delisar.relo.Event;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class serviceAPI {
    private static Retrofit retrofit;
    private static final String BASE_URL = "192.168.0.102:8080/api/event";

    public static Retrofit getAPIdata() {

        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder ()
                    .baseUrl ( BASE_URL )
                    .addConverterFactory ( GsonConverterFactory.create () )
                    .build();
        }
        return retrofit;
    }
}
