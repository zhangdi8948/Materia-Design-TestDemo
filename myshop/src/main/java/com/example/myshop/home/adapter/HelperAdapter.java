package com.example.myshop.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshop.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.HelperViewHolder> {

    private ArrayList<String> data;
    private Context context;

    public HelperAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public HelperViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (null == context) {
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main_helper_menu_item, viewGroup, false);
        return new HelperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelperViewHolder helperViewHolder, int i) {

        helperViewHolder.plateName.setText(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class HelperViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.plate_name)
        TextView plateName;
        @BindView(R.id.plate_cancel)
        ImageView cancel;

        public HelperViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
