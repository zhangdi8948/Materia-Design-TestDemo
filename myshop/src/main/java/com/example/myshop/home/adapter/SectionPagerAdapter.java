package com.example.myshop.home.adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.myshop.home.GoodsFragment;
import com.example.myshop.home.bean.GoodsModule;

import java.util.ArrayList;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<GoodsModule> fragments;

    public SectionPagerAdapter(FragmentManager fm, ArrayList<GoodsModule> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new GoodsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("goods", fragments.get(i));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
