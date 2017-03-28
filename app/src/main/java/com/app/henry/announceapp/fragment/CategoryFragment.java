package com.app.henry.announceapp.fragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.henry.announceapp.CategoriesActivity;
import com.app.henry.announceapp.R;
import com.app.henry.announceapp.adapter.CategoryAdapter;
import com.app.henry.announceapp.model.Category;

import java.util.List;

/**
 * Created by Eduardo on 26/03/2017.
 */

public class CategoryFragment extends android.support.v4.app.Fragment {

    private RecyclerView mRecyclerView;
    private List<Category> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list_categories);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                CategoryAdapter adapter = (CategoryAdapter) mRecyclerView.getAdapter();

                /*if(mList.size() == layoutManager.findLastCompletelyVisibleItemPosition() + 1 ){
                    List<Category> listaux = ((CategoriesActivity) getActivity()).createCategoriesList(3);
                    for(int i = 0; i < listaux.size(); i++){
                        adapter.addListItem(listaux.get(i), mList.size());
                    }

                }*/
            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mList = ((CategoriesActivity) getActivity()).createCategoriesList(3);
        CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(categoryAdapter);

        return view;
    }
}
