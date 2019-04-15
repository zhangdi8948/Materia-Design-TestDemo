package com.example.myshop.recipe_detail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.home.bean.ItemBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder> {

    private ArrayList<ItemBean> data;
    private Context context;

    public IngredientsAdapter(ArrayList<ItemBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (null == context) {
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.activity_recipes_detail_ingredients_item, viewGroup, false);
        return new IngredientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder ingredientsViewHolder, int i) {

        ItemBean bean = data.get(i);
        Glide.with(context)
                .load(bean.getResId())
                .override(200, 200)
                .centerCrop()
                .into(ingredientsViewHolder.iv);
        ingredientsViewHolder.name.setText(bean.getName());
        ingredientsViewHolder.pcs.setText(bean.getCal());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class IngredientsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.detail_ingredients_iv)
        ImageView iv;
        @BindView(R.id.detail_ingredients_name)
        TextView name;
        @BindView(R.id.detail_ingredients_pcs)
        TextView pcs;

        public IngredientsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
