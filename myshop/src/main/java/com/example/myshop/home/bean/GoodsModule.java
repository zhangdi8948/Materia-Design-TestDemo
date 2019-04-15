package com.example.myshop.home.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class GoodsModule implements Parcelable {

    private String title;
    private ArrayList<ItemBean> data;

    public GoodsModule(String title, ArrayList<ItemBean> data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ItemBean> getData() {
        return data;
    }

    public void setData(ArrayList<ItemBean> data) {
        this.data = data;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeList(this.data);
    }

    protected GoodsModule(Parcel in) {
        this.title = in.readString();
        this.data = new ArrayList<ItemBean>();
        in.readList(this.data, ItemBean.class.getClassLoader());
    }

    public static final Creator<GoodsModule> CREATOR = new Creator<GoodsModule>() {
        @Override
        public GoodsModule createFromParcel(Parcel source) {
            return new GoodsModule(source);
        }

        @Override
        public GoodsModule[] newArray(int size) {
            return new GoodsModule[size];
        }
    };
}
