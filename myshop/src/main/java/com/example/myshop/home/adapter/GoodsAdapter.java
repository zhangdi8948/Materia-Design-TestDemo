package com.example.myshop.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.common.SlideLeftToCancelView;
import com.example.myshop.home.bean.ItemBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {

    private ArrayList<ItemBean> data;
    private Context context;

    public GoodsAdapter(ArrayList<ItemBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (null == context) {
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_main_goods_item, viewGroup, false);
        return new GoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsViewHolder goodsViewHolder, int i) {

        ItemBean bean = data.get(i);
        Glide.with(context).load(bean.getResId())
                .override(200, 200)
                .centerCrop()
                .into(goodsViewHolder.pic);
        goodsViewHolder.name.setText(bean.getName());
        goodsViewHolder.cal.setText(bean.getCal());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class GoodsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.goods_iv)
        ImageView pic;
        @BindView(R.id.goods_name)
        TextView name;
        @BindView(R.id.goods_cal)
        TextView cal;
        @BindView(R.id.goods_add)
        SlideLeftToCancelView add;
        @BindView(R.id.goods_card)
        CardView card;

        public GoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
