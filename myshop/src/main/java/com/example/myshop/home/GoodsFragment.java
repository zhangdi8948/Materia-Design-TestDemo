package com.example.myshop.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myshop.R;
import com.example.myshop.home.adapter.GoodsAdapter;
import com.example.myshop.home.bean.GoodsModule;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsFragment extends Fragment {

    @BindView(R.id.main_goods_recycler)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_goods_layout, container, false);
        ButterKnife.bind(this, view);

        GoodsModule goods = getArguments().getParcelable("goods");
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        GoodsAdapter adapter = new GoodsAdapter(goods.getData());
        recyclerView.setAdapter(adapter);
        return view;
    }
}
