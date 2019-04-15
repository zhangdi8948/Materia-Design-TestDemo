package com.example.myshop.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyCircleImageView extends CircleImageView {

    public MyCircleImageView(Context context) {
        super(context);
    }

    public MyCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setScaleType(ScaleType scaleType) {

    }
}
