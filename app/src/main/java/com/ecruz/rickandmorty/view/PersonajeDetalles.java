package com.ecruz.rickandmorty.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ecruz.rickandmorty.R;
import com.ecruz.rickandmorty.contract.PersonajeDetailContract;
import com.ecruz.rickandmorty.model.Personaje;
import com.ecruz.rickandmorty.presenter.PersonajeDetailsPresenter;
import com.ecruz.rickandmorty.presenter.PersonajePresenter;
import com.ecruz.rickandmorty.utils.EpisodioAdapter;

public class PersonajeDetalles extends AppCompatActivity implements PersonajeDetailContract.View {

    private PersonajeDetailsPresenter personajePresenter;
    private ProgressBar pbLoadBackdrop;
    private ImageView character;
    private TextView nombre;
    private TextView genero;
    private TextView status;
    RecyclerView rvCast;
    EpisodioAdapter episodioAdapter;

    private String movieName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_detalles);
        pbLoadBackdrop = findViewById(R.id.pb_cast_loadings);
        nombre = findViewById(R.id.nombredetail);
        status = findViewById(R.id.statusdetail);
        character = findViewById(R.id.imgDetails);
        genero = findViewById(R.id.genderdetails);
        rvCast = findViewById(R.id.rv_cast);
        Intent mIntent = getIntent();
        int personajeId = mIntent.getIntExtra("PERSONAJE_KEY", 2);
        personajePresenter = new PersonajeDetailsPresenter(this);
        personajePresenter.requestPersonajeData(personajeId);
    }

    @Override
    public void showProgress() {
        pbLoadBackdrop.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoadBackdrop.setVisibility(View.GONE);
    }

    @Override
    public void setDataToViews(Personaje personaje) {
        if(personaje != null){
            nombre.setText("Nombre: "+personaje.getName());
            status.setText("Status: "+personaje.getStatus());
            genero.setText("Genero: "+personaje.getGender());
            Glide.with(this).load(personaje.getImage()).into(character);
            episodioAdapter = new EpisodioAdapter(personaje.getEpisode());
            rvCast.setAdapter(episodioAdapter);
        }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this,getString(R.string.error_data),Toast.LENGTH_SHORT).show();
    }
}