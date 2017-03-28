package com.app.henry.announceapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.henry.announceapp.R;
import com.app.henry.announceapp.model.City;

import java.util.List;

/**
 * Created by Henry on 28/03/2017.
 */

public class ChooseCityAdapter extends RecyclerView.Adapter<ChooseCityAdapter.MyViewHolder>{

    private List<City>      mList;
    private LayoutInflater  mLayoutInflater;

    public ChooseCityAdapter(Context context, List<City> list){
        this.mList = list;
        mLayoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName;
        public TextView tvLocation;
        public TextView tvCep;

        public MyViewHolder(View item){
            super(item);
            tvName = (TextView) item.findViewById(R.id.);
        }

    }

}
