package com.example.myshop.recipes;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ScalePageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(@NonNull View view, float v) {

        before(view);
        //设置缩放中心为右上角
        view.setPivotX(view.getWidth());
        view.setPivotY(0);
        //v表示item与当前显示的item之间position差值
        //v==0表示当前显示这个item
        if (v == 0) {

            currentPosition();
        } else if (v < -1) {//显示的item左边第二个及以上的item，如何显示

            view.setScaleX(1);
            view.setScaleY(1);
        } else if (v < 0) {//显示的item左边第一个item

            //从小到大缩放
            view.setScaleX(1+v);
            view.setScaleY(1+v);
        } else if (v <= 1) {//显示的item右边第一个item

            //从大到小缩放
            view.setScaleX(1-v);
            view.setScaleY(1-v);
        } else {//显示的item右边第二个及以上的item

            view.setScaleX(1);
            view.setScaleY(1);
        }
    }

    public void before(View view){}

    public void currentPosition(){}
}
