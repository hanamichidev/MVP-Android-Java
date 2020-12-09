package com.ecruz.rickandmorty.presenter;

import com.ecruz.rickandmorty.contract.PersonajeDetailContract;
import com.ecruz.rickandmorty.model.Personaje;
import com.ecruz.rickandmorty.service.PersonajeDetailsModel;

public class PersonajeDetailsPresenter implements PersonajeDetailContract.Presenter, PersonajeDetailContract.Model.OnFinishedListener {

    private PersonajeDetailContract.View personajeDetailView;
    private PersonajeDetailContract.Model personajeDetailsModel;

    public PersonajeDetailsPresenter(PersonajeDetailContract.View personajeDetailView) {
        this.personajeDetailView = personajeDetailView;
        this.personajeDetailsModel = new PersonajeDetailsModel();
    }

    @Override
    public void onFinished(Personaje personaje) {
        if(personajeDetailView != null){
            personajeDetailView.hideProgress();
        }
        personajeDetailView.setDataToViews(personaje);
    }

    @Override
    public void onFailure(Throwable t) {
        if(personajeDetailView != null){
            personajeDetailView.hideProgress();
        }
        personajeDetailView.onResponseFailure(t);
    }

    @Override
    public void onDestroy() {
        personajeDetailView = null;
    }

    @Override
    public void requestPersonajeData(int personajeId) {
        if(personajeDetailView != null){
            personajeDetailView.showProgress();
        }
        personajeDetailsModel.getPersonajeDetails(this, personajeId);
    }
}
