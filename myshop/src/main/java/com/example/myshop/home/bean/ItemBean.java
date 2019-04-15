package com.example.myshop.home.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemBean implements Parcelable {

    private String name;
    private int resId;
    private String cal;

    public ItemBean(String name, int resId, String cal) {
        this.name = name;
        this.resId = resId;
        this.cal = cal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.resId);
        dest.writeString(this.cal);
    }

    protected ItemBean(Parcel in) {
        this.name = in.readString();
        this.resId = in.readInt();
        this.cal = in.readString();
    }

    public static final Creator<ItemBean> CREATOR = new Creator<ItemBean>() {
        @Override
        public ItemBean createFromParcel(Parcel source) {
            return new ItemBean(source);
        }

        @Override
        public ItemBean[] newArray(int size) {
            return new ItemBean[size];
        }
    };
}
