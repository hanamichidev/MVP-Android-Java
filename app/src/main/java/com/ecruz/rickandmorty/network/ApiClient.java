package com.ecruz.rickandmorty.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://rickandmortyapi.com/";
    private static Retrofit retrofit = null;
    public static final String IMAGE_BASE_URL = "https://rickandmortyapi.com/api/character/avatar/";
    public static final String BACKDROP_BASE_URL = "https://rickandmortyapi.com/api/character/avatar/2.jpeg";

    /**
     * This method returns retrofit client instance
     *
     * @return Retrofit object
     */
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}