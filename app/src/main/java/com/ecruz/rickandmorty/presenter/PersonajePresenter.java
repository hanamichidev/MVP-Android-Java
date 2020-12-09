package com.ecruz.rickandmorty.presenter;

import com.ecruz.rickandmorty.contract.PersonajeListContract;
import com.ecruz.rickandmorty.model.Personaje;
import com.ecruz.rickandmorty.service.PersonajeListModel;

import java.util.List;

public class PersonajePresenter implements PersonajeListContract.Presenter, PersonajeListContract.Model.OnFinishedListener {

    private PersonajeListContract.View personajeListView;
    private PersonajeListContract.Model personajeListModel;

    public PersonajePresenter(PersonajeListContract.View personajeListView) {
        this.personajeListView = personajeListView;
        this.personajeListModel = new PersonajeListModel();
    }

    @Override
    public void onDestroy() {
        this.personajeListView = null;
    }

    @Override
    public void getMoreData(int pageNo) {
        if (personajeListView != null){
            personajeListView.showProgress();
        }
        personajeListModel.getPersonajeList(this, pageNo);
    }

    @Override
    public void requestDataFromServer() {
        if (personajeListView != null){
            personajeListView.showProgress();
        }
        personajeListModel.getPersonajeList(this, 1);
    }

    @Override
    public void onFinished(List<Personaje> personajeArrayList) {
        personajeListView.setDataToRecyclerView(personajeArrayList);
        if (personajeListView != null){
            personajeListView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        personajeListView.onResponseFailure(t);
        if (personajeListView != null){
            personajeListView.hideProgress();
        }
    }
}
