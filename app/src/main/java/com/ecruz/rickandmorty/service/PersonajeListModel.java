package com.ecruz.rickandmorty.service;

import android.util.Log;

import com.ecruz.rickandmorty.contract.PersonajeListContract;
import com.ecruz.rickandmorty.model.Personaje;
import com.ecruz.rickandmorty.model.PersonajeListResponse;
import com.ecruz.rickandmorty.network.ApiClient;
import com.ecruz.rickandmorty.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonajeListModel implements PersonajeListContract.Model{

    private final String TAG = "PersonajeListModel";
    private int pageNo = 1;

    @Override
    public void getPersonajeList(OnFinishedListener onFinishedListener, int pageNo) {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<PersonajeListResponse> call = apiService.getPersonajes(pageNo);
        call.enqueue(new Callback<PersonajeListResponse>() {
            @Override
            public void onResponse(Call<PersonajeListResponse> call, Response<PersonajeListResponse> response) {
                List<Personaje> personajes = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + personajes.size());
                onFinishedListener.onFinished(personajes);
            }

            @Override
            public void onFailure(Call<PersonajeListResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });

    }
}
