package com.app.henry.announceapp;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.henry.announceapp.fragment.CategoryFragment;
import com.app.henry.announceapp.fragment.ChooseCityFragment;
import com.app.henry.announceapp.model.City;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class ChooseCityActivity extends AppCompatActivity {

    private static final String URL_DATA_CITIES = "http://192.168.0.105/announce-rest/?request=get_all_cities";
    private List<City> cityList;
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


    public List<City> getCities(){
        List<City> list = new ArrayList<>();
        String name[]       = new String[]{"Natal-RN","João Câmara-RN","Parazinho-RN"};
        String location[]   = new String[]{"55.459432,32.342394","55.459432,32.342395","55.49432,32.34394"};

        for(int i = 0; i < 3; i++){
            City city = new City(name[i % name.length],location[i % location.length]);
            list.add(city);
        }
        return list;
    }


    public List<City> getCitiesData() {
        cityList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                URL_DATA_CITIES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            JSONArray data = jsonResponse.getJSONArray("cities");
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject o = data.getJSONObject(i);
                                City c = new City(o.getString("name"),o.getString("location"));
                                cityList.add(c);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage()+" + "+error.networkResponse,Toast.LENGTH_LONG).show();
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        return cityList;
    }

}
