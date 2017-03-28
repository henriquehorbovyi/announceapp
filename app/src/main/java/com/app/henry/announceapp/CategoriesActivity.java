package com.app.henry.announceapp;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.app.henry.announceapp.fragment.CategoryFragment;
import com.app.henry.announceapp.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        mToolbar = (Toolbar) findViewById(R.id.maintoolbar);
        setSupportActionBar(mToolbar);



        // FRAGMENT
        CategoryFragment frag = (CategoryFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(frag == null) {
            frag = new CategoryFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_categories, frag, "mainFrag");
            ft.commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_item_filter:
                Snackbar.make(this.findViewById(R.id.toolbar_item_filter),"Change filter...",Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
                break;
            case R.id.toolbar_item_settings:
                Snackbar.make(this.findViewById(R.id.toolbar_item_filter),"Settings...",Snackbar.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public List<Category> createCategoriesList(int qtd){
        String[] names  = new String[]{"Lojas","Cinemas","Bares"};
        int[]    images = new int[]{R.drawable.md, R.drawable.city,R.drawable.airplane};
        List<Category>  list  = new ArrayList<>();
        for(int i = 0; i < qtd; i++){
            Category category = new Category(names[i % names.length], images[i % images.length] );
            list.add(category);
        }
        return list;
    }

}
