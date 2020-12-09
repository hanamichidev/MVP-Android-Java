package com.ecruz.rickandmorty.contract;

import com.ecruz.rickandmorty.model.Personaje;

public interface PersonajeDetailContract {

    interface Model {

        interface OnFinishedListener {
            void onFinished(Personaje personaje);

            void onFailure(Throwable t);
        }

        void getPersonajeDetails(OnFinishedListener onFinishedListener, int personajeId);
    }

    interface View {

        void showProgress();

        void hideProgress();

        void setDataToViews(Personaje personaje);

        void onResponseFailure(Throwable throwable);
    }

    interface Presenter {
        void onDestroy();

        void requestPersonajeData(int personajeId);
    }

}
