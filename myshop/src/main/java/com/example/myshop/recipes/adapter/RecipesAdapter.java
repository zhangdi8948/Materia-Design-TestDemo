package com.example.myshop.recipes.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.recipes.bean.RecipesBean;

import java.util.ArrayList;

public class RecipesAdapter extends PagerAdapter {

    private ArrayList<RecipesBean> data;
    private Context context;

    public RecipesAdapter(ArrayList<RecipesBean> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if (null == context) {
            context = container.getContext();
        }
        RecipesBean bean = data.get(position);
        View layout = LayoutInflater.from(context).inflate(R.layout.activity_recipes_viewpager_item, container, false);
        ImageView iv = layout.findViewById(R.id.recipes_iv);
        Glide.with(context).load(bean.getImage())
                .override(500, 600)
                .centerCrop()
                .into(iv);
        TextView name = layout.findViewById(R.id.recipes_name);
        name.setText(bean.getName());
        name.setAlpha(0);
        TextView have = layout.findViewById(R.id.recipes_have);
        have.setText(bean.getHave());
        have.setAlpha(0);
        TextView m = layout.findViewById(R.id.recipes_m);
        m.setText(bean.getM());
        m.setAlpha(0);
        TextView cal = layout.findViewById(R.id.recipes_cal);
        cal.setText(bean.getCal());
        cal.setAlpha(0);
        TextView per = layout.findViewById(R.id.recipes_per);
        per.setText(bean.getPer());
        per.setAlpha(0);
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
