package com.example.myshop.recipes.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class RecipesBean implements Parcelable {

    private String name;
    private String image;
    private String have;
    private String m;
    private String cal;
    private String per;

    public RecipesBean(String name, String image, String have, String m, String cal, String per) {
        this.name = name;
        this.image = image;
        this.have = have;
        this.m = m;
        this.cal = cal;
        this.per = per;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHave() {
        return have;
    }

    public void setHave(String have) {
        this.have = have;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.image);
        dest.writeString(this.have);
        dest.writeString(this.m);
        dest.writeString(this.cal);
        dest.writeString(this.per);
    }

    protected RecipesBean(Parcel in) {
        this.name = in.readString();
        this.image = in.readString();
        this.have = in.readString();
        this.m = in.readString();
        this.cal = in.readString();
        this.per = in.readString();
    }

    public static final Parcelable.Creator<RecipesBean> CREATOR = new Parcelable.Creator<RecipesBean>() {
        @Override
        public RecipesBean createFromParcel(Parcel source) {
            return new RecipesBean(source);
        }

        @Override
        public RecipesBean[] newArray(int size) {
            return new RecipesBean[size];
        }
    };
}
