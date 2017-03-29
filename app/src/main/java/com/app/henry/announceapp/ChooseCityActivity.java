package com.app.henry.announceapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.henry.announceapp.fragment.CategoryFragment;
import com.app.henry.announceapp.fragment.ChooseCityFragment;
import com.app.henry.announceapp.model.City;

import java.util.ArrayList;
import java.util.List;

public class ChooseCityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);


        ChooseCityFragment fragment   =  (ChooseCityFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(fragment == null){
            fragment = new ChooseCityFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_choosecity,fragment,"mainFrag");
            ft.commit();
        }
    }

    public List<City> createCityList(int qtd){
        List<City> list = new ArrayList<>();
        String name[]       = new String[]{"Natal-RN","João Câmara-RN","Parazinho-RN"};
        String location[]   = new String[]{"55.459432,32.342394","55.459432,32.342395","55.49432,32.34394"};
        String cep[]        = new String[]{"123","321","59586000"};
        for(int i = 0; i < qtd; i++){
            City city = new City(name[i % name.length],location[i % location.length],cep[i % cep.length]);
            list.add(city);
        }
        return list;
    }

}
