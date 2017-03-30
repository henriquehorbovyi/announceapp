package com.app.henry.announceapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.henry.announceapp.CategoriesActivity;
import com.app.henry.announceapp.ChooseCityActivity;
import com.app.henry.announceapp.R;
import com.app.henry.announceapp.adapter.ChooseCityAdapter;
import com.app.henry.announceapp.interfaces.RecyclerViewClickListener;
import com.app.henry.announceapp.interfaces.RecyclerViewClickListenerHacked;
import com.app.henry.announceapp.model.City;

import java.util.List;

/**
 * Created by Henry on 28/03/2017.
 */

public class ChooseCityFragment extends Fragment implements RecyclerViewClickListenerHacked{

    private RecyclerView mRecyclerView;
    private List<City> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choosecity,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_cities);
        mRecyclerView.setHasFixedSize(true);
        //onTouch
        /*mRecyclerView.addOnItemTouchListener(
                new RecyclerViewClickListener(getActivity(), mRecyclerView, new RecyclerViewClickListener.OnItemClickListener() {
                    @Override public void onPress(View view, int position) {
                        startActivity(new Intent(getActivity(), CategoriesActivity.class));
                        getActivity().finish();
                    }

                    @Override public void onLongPress(View view, int position) {
                        //Toast.makeText(getActivity(),"LONG PRESS: "+position,Toast.LENGTH_LONG).show();
                    }
                })
        );*/

        //onScroll
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


        //GridLayoutManager layoutManager = new GridLayoutManager(?);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mList = ((ChooseCityActivity) getActivity()).createCityList(3);
        ChooseCityAdapter chooseCityAdapter = new ChooseCityAdapter(getActivity(), mList);
        chooseCityAdapter.addRecyclerViewClickListenerHacked(this);
        mRecyclerView.setAdapter(chooseCityAdapter);

        return view;
    }


    //onClick
    @Override
    public void onClickListener(View view, int position) {
        startActivity(new Intent(getActivity(), CategoriesActivity.class));
        getActivity().finish();
        //ChooseCityAdapter chooseCityAdapter = (ChooseCityAdapter) mRecyclerView.getAdapter();
        //chooseCityAdapter.removeListItem(position);
    }

}
