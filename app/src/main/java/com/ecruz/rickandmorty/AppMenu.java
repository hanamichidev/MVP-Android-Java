package com.ecruz.rickandmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.ecruz.rickandmorty.fragments.CapitulosFragment;
import com.ecruz.rickandmorty.fragments.PersonajesFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class AppMenu extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    RelativeLayout menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_menu);

        menu = findViewById(R.id.rltLayoutMenu);
        chipNavigationBar = findViewById(R.id.btmNavigationMenu);
        getSupportFragmentManager().beginTransaction().replace(R.id.appMenu_fragmentContainer,new PersonajesFragment()).commit();
        chipNavigationBar.setItemSelected(R.id.bottom_nav_personajes,true);
        bottomMenuInitialisation();
    }

    private void bottomMenuInitialisation() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.bottom_nav_personajes:
                        menu.setBackgroundColor(getColor(R.color.VerdeRick));
                        fragment = new PersonajesFragment();
                        break;
                    case R.id.bottom_nav_capitulos:
                        menu.setBackgroundColor(getColor(R.color.AmarilloMorty));
                        fragment = new CapitulosFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.appMenu_fragmentContainer,fragment).commit();
            }
        });

    }
}