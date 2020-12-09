package com.ecruz.rickandmorty.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ecruz.rickandmorty.R;
import com.ecruz.rickandmorty.contract.PersonajeListContract;
import com.ecruz.rickandmorty.model.Personaje;
import com.ecruz.rickandmorty.presenter.PersonajePresenter;
import com.ecruz.rickandmorty.utils.GridSpacingItemDecoration;
import static com.ecruz.rickandmorty.utils.GridSpacingItemDecoration.dpToPx;
import com.ecruz.rickandmorty.view.PersonajeListAdapter;

import java.util.ArrayList;
import java.util.List;

public class PersonajesFragment extends Fragment implements PersonajeListContract.View {

    private PersonajePresenter personajePresenter;
    private RecyclerView rvPersonajeList;
    private List<Personaje> personajeList;
    private PersonajeListAdapter personajeListAdapter;
    private ProgressBar pbLoading;
    private int pageNo = 1;
    private GridLayoutManager mLayoutManager;
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 0;
    int visibleItemCount, totalItemCount, firstVisibleItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personajes, container, false);
        rvPersonajeList = view.findViewById(R.id.rv_personaje_list);
        pbLoading = view.findViewById(R.id.pb_loading);
        personajeList = new ArrayList<>();
        mLayoutManager = new GridLayoutManager(getContext(), 2);
        rvPersonajeList.setLayoutManager(mLayoutManager);
        rvPersonajeList.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(getContext(), 10), true));
        rvPersonajeList.setItemAnimator(new DefaultItemAnimator());
        rvPersonajeList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = rvPersonajeList.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();
                // Handling the infinite scroll
                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount) == (firstVisibleItem + visibleThreshold)) {
                    pageNo++;
                    personajePresenter.getMoreData(pageNo);
                    loading = true;
                }
            }
        });
        personajePresenter = new PersonajePresenter(this);
        personajePresenter.requestDataFromServer();
        return view;
    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(List<Personaje> personajeArrayList) {
        personajeList.addAll(personajeArrayList);
        personajeListAdapter = new PersonajeListAdapter(personajeList, getContext());
        rvPersonajeList.setAdapter(personajeListAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Log.e("ERROR", throwable.getMessage());
    }
}