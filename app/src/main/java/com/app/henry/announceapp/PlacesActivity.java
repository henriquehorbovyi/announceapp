package com.app.henry.announceapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import com.app.henry.announceapp.fragment.PlaceFragment;
import com.app.henry.announceapp.model.Place;

import java.util.ArrayList;
import java.util.List;

public class PlacesActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        toolbar = (Toolbar) findViewById(R.id.placestoolbar);
        setSupportActionBar(toolbar);

        PlaceFragment fragment   =  (PlaceFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(fragment == null){
            fragment = new PlaceFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_places,fragment,"mainFrag");
            ft.commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.places_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public List<Place> createPlaceList(int qtd){
        List<Place> list = new ArrayList<>();
        String name[]       = new String[]{"Super mercado Exemplo","Estabelecimento Tal","Loja Tal","Cinema Tal","Exemplo de Empresa"};
        int    img[]        = new int[]{R.drawable.city,R.drawable.city,R.drawable.city,R.drawable.city,R.drawable.city};
        String location[]   = new String[]{"55.459432,32.342394","55.459432,32.342395","55.49432,32.34394","55.459432,32.342394","55.459432,32.342394"};
        for(int i = 0; i < qtd; i++){
            Place p = new Place(name[i % name.length],location[i % location.length], img[i % img.length]);
            list.add(p);
        }
        return list;
    }
}
