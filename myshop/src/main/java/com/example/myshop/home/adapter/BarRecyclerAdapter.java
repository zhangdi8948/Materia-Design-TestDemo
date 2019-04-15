package com.example.myshop.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.home.bean.ItemBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BarRecyclerAdapter extends RecyclerView.Adapter<BarRecyclerAdapter.MyViewHolder> {

    private ArrayList<ItemBean> data;
    private Context context;

    public BarRecyclerAdapter(ArrayList<ItemBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (null == context) {
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main_bar_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Glide.with(context).load(data.get(i).getResId())
                .override(300, 300)
                .centerCrop()
                .into(myViewHolder.barIv);
        myViewHolder.barCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.bar_iv)
        ImageView barIv;
        @BindView(R.id.bar_card)
        CardView barCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
