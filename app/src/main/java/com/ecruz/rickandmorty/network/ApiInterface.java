package com.ecruz.rickandmorty.network;

import com.ecruz.rickandmorty.model.Personaje;
import com.ecruz.rickandmorty.model.PersonajeListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/character/")
    Call<PersonajeListResponse> getPersonajes(@Query("page") int pageNo);

    @GET("api/character/{personaje_id}")
    Call<Personaje> getPersonajesDetails(@Path("personaje_id") int personajeId);

}
