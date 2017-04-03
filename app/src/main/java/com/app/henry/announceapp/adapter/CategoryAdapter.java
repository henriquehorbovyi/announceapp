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
import com.app.henry.announceapp.model.Category;
import java.util.List;

/**
 * Created by Henry on 26/03/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<Category> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewClickListenerHacked clickListenerHacked;

    public CategoryAdapter(Context context, List<Category> l){
        mList = l;
        mLayoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("LOG","onCreateViewHolder()");
        View view = mLayoutInflater.inflate(R.layout.item_category, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i("LOG","onBindViewHolder()");
        holder.ivCategory.setImageResource(mList.get(position).getImage());
        holder.tvCategory.setText(mList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void addRecyclerViewClickListenerHacked(RecyclerViewClickListenerHacked recyclerView){
        clickListenerHacked = recyclerView;
    }

    public void addListItem(Category category, int position){
        mList.add(category);
        notifyItemInserted(position);
    }

    /* MY VIEW HOLDER CLASS */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView ivCategory;
        public TextView tvCategory;

        public MyViewHolder(View itemView){
            super(itemView);
            ivCategory = (ImageView) itemView.findViewById(R.id.iv_category);
            tvCategory = (TextView)  itemView.findViewById(R.id.tv_category_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            if(clickListenerHacked != null){
                clickListenerHacked.onClickListener(v, getPosition());
            }

        }

    }

}
