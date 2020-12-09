package com.ecruz.rickandmorty.contract;

import com.ecruz.rickandmorty.model.Personaje;

import java.util.List;

public interface PersonajeListContract {

    interface Model {

        interface OnFinishedListener {
            void onFinished(List<Personaje> personajeArrayList);

            void onFailure(Throwable t);
        }

        void getPersonajeList(OnFinishedListener onFinishedListener, int pageNo);

    }

    interface View {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Personaje> personajeArrayList);

        void onResponseFailure(Throwable throwable);

    }

    interface Presenter {

        void onDestroy();

        void getMoreData(int pageNo);

        void requestDataFromServer();

    }

}
