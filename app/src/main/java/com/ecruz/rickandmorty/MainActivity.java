package com.ecruz.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animaciones agregadas
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        //Declaracion de elementos UI
        TextView titulo = findViewById(R.id.txtView_titulo);
        TextView subtitulo = findViewById(R.id.txtView_subtitulo);
        ImageView logo = findViewById(R.id.imgView_logo);

        //Asignacion de animaciones
        titulo.setAnimation(animacion2);
        subtitulo.setAnimation(animacion2);
        logo.setAnimation(animacion1);

        //Inicio de proceso de Splash Screen utilizando handler para no afectar UI Thread principal
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, AppMenu.class);
                startActivity(intent);
                finish();
            }
        },3500);
    }
}