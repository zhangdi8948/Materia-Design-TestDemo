package com.example.myshop.common;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.myshop.R;

//左滑改变控件图标并拉长控件，松手还原控件大小
public class SlideLeftToCancelView extends RelativeLayout {

    private int lastX;//上一次滑动的x值
    private boolean toggle = false, //两种图片状态
            isSlide = false;//是否开始滑动
    //按钮图片
    private ImageView imageView;
    //保存控件初始的left、top、right、bottom值
    private int originalLeft, originalRight;

    public SlideLeftToCancelView(Context context) {
        super(context);
    }

    public SlideLeftToCancelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SlideLeftToCancelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //加入图片
    private void init() {

        imageView = new ImageView(getContext());
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
        LayoutParams params = new LayoutParams(width, width);
        imageView.setLayoutParams(params);
        imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.add));
        addView(imageView);
    }

    //获取控件初始left、top、right、bottom
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (originalLeft == 0 && originalRight == 0) {
            originalRight = r;
            originalLeft = l;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                //请求父控件不要拦截事件
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                //计算滑动距离
                int move = x - lastX;
                //如果是向左滑动
                if(move < 0) {
                    //不是正在滑动中
                    if (!isSlide) {
                        isSlide = true;
                        //改变图片和背景状态
                        if (!toggle) {
                            toggle = true;
                            imageView.setImageBitmap(null);
                            imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.cancel));
                            setBackgroundResource(R.drawable.purple_circlecorner_rectangle);
                        } else {
                            toggle = false;
                            imageView.setImageBitmap(null);
                            imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.add));
                            setBackgroundResource(R.drawable.white_circlecorner_rectangle);
                        }
                    }
                    //根据滑动距离从新设置控件的left
                    layout(getLeft() + move, getTop(), getRight(), getBottom());
                }
                break;
            case MotionEvent.ACTION_UP://松手后
                lastX = 0;
                //还原控件初始left、top、right、bottom
                layout(originalLeft, getTop(), originalRight, getBottom());
                //改为不是正在滑动中
                isSlide = false;
                break;
        }
        lastX = x;
        return true;
    }
}
