package com.app.henry.announceapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.henry.announceapp.CategoriesActivity;
import com.app.henry.announceapp.PlacesActivity;
import com.app.henry.announceapp.R;
import com.app.henry.announceapp.adapter.CategoryAdapter;
import com.app.henry.announceapp.adapter.PlaceAdapter;
import com.app.henry.announceapp.interfaces.RecyclerViewClickListenerHacked;
import com.app.henry.announceapp.model.Place;

import java.util.List;

/**
 * Created by henry on 03/04/17.
 */

public class PlaceFragment extends Fragment implements RecyclerViewClickListenerHacked{

    private RecyclerView mRecyclerView;
    private List<Place>  mList;

    @Override
    public View onCreateView(LayoutInflater inflater,final ViewGroup container, Bundle savedInstanceState) {
        View view       = inflater.inflate(R.layout.fragment_places,container,false);
        mRecyclerView   = (RecyclerView) view.findViewById(R.id.rv_list_places);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mList = ((PlacesActivity) getActivity()).createPlaceList(5);
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(),mList);
        placeAdapter.addRecyclerViewClickListenerHacked(this);
        mRecyclerView.setAdapter(placeAdapter);
        return view;
    }


    @Override
    public void onClickListener(View view, int position) {
        //TODO: OPEN DETAILS...
        Snackbar.make(view,"Do something...",Snackbar.LENGTH_SHORT).show();
    }
}
