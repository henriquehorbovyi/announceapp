package com.app.henry.announceapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.henry.announceapp.R;
import com.app.henry.announceapp.interfaces.RecyclerViewClickListenerHacked;
import com.app.henry.announceapp.model.Place;

import java.util.List;

/**
 * Created by henry on 03/04/17.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder> {

    private List<Place>     mList;
    private LayoutInflater  layoutInflater;
    private RecyclerViewClickListenerHacked clickListenerHacked;

    public PlaceAdapter(Context context, List<Place> list) {
        this.mList = list;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_place, parent, false);
        PlaceAdapter.MyViewHolder myViewHolder = new PlaceAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvName.setText(mList.get(position).getName());
        holder.imageView.setImageResource(mList.get(position).getImg());
    }

    public void addListItem(Place place, int position){
        mList.add(place);
        notifyItemInserted(position);
    }

    public void removeListItem(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addRecyclerViewClickListenerHacked(RecyclerViewClickListenerHacked r){
        this.clickListenerHacked = r;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView     tvName;
        public ImageView    imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName      = (TextView)    itemView.findViewById(R.id.tv_namePlace);
            imageView   = (ImageView)   itemView.findViewById(R.id.iv_place);
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
