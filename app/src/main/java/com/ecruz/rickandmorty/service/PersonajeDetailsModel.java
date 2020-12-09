package com.ecruz.rickandmorty.service;

import android.util.Log;

import com.ecruz.rickandmorty.contract.PersonajeDetailContract;
import com.ecruz.rickandmorty.model.Personaje;
import com.ecruz.rickandmorty.network.ApiClient;
import com.ecruz.rickandmorty.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonajeDetailsModel implements PersonajeDetailContract.Model {
    @Override
    public void getPersonajeDetails(OnFinishedListener onFinishedListener, int personajeId) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Personaje> call = apiService.getPersonajesDetails(personajeId);
        call.enqueue(new Callback<Personaje>() {
            @Override
            public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                Personaje movie = response.body();
                Log.d("PERSONAJEDETAILS", "Personaje data received: " + movie.toString());
                onFinishedListener.onFinished(movie);
            }

            @Override
            public void onFailure(Call<Personaje> call, Throwable t) {
                Log.e("PERSONAJEDETAILS", t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}
