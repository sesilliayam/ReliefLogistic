package com.delisar.relo.Event;

import retrofit2.Call;
import retrofit2.http.GET;

public interface interfaceAPI {
    String API_KEY = "c893ca7b86d8a6bfa0576e3427eaaf06";

    @GET("discover/movie?api_key="+API_KEY+"&language=en-US")
    Call<responseAPI> getMovieData();
}
