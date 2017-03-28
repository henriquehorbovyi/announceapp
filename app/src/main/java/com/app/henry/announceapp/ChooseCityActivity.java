package com.app.henry.announceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.henry.announceapp.fragment.ChooseCityFragment;

public class ChooseCityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);

       //ChooseCityFragment chooseCityFragment = (ChooseCityFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");

    }
}
