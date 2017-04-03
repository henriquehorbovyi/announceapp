package com.app.henry.announceapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.app.henry.announceapp.R;
import com.app.henry.announceapp.interfaces.RecyclerViewClickListenerHacked;
import com.app.henry.announceapp.model.City;

import java.util.List;

/**
 * Created by Henry on 28/03/2017.
 */

public class ChooseCityAdapter extends RecyclerView.Adapter<ChooseCityAdapter.MyViewHolder>{

    private List<City>      mList;
    private LayoutInflater  mLayoutInflater;
    private RecyclerViewClickListenerHacked clickListenerHacked;

    public ChooseCityAdapter(Context context, List<City> list){
        this.mList = list;
        mLayoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("LOG","onCreateViewHolder()");
        View view = mLayoutInflater.inflate(R.layout.item_city, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvName.setText(mList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void addRecyclerViewClickListenerHacked(RecyclerViewClickListenerHacked r){
        this.clickListenerHacked = r;
    }

    public void addListItem(City city, int position){
        mList.add(city);
        notifyItemInserted(position);
    }

    public void removeListItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }



    /* MY VIEW HOLDER CLASS */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvName;

        public MyViewHolder(View itemView){
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_city_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListenerHacked != null){
                clickListenerHacked.onClickListener(v, getPosition());
            }
        }
    }

}
