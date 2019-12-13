package com.delisar.relo.Event;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class serviceAPI {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https:/api.themoviedb.org/3/";

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
