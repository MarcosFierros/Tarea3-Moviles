package com.iteso.sesion9.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemProduct implements Parcelable {

    private String name;
    private String store;
    private String phone;
    private String title;
    private String location;
    private int image;
    private int code;

    public static final Parcelable.Creator<ItemProduct> CREATOR =
            new Parcelable.Creator<ItemProduct>() {

                @Override
                public ItemProduct createFromParcel(Parcel source) {
                    return new ItemProduct(source);
                }

                @Override
                public ItemProduct[] newArray(int size) {
                    return new ItemProduct[size];
                }
            };

    public ItemProduct() {
    }

    public ItemProduct(Parcel in) {
        this.name = in.readString();
        this.store = in.readString();
        this.phone = in.readString();
        this.title = in.readString();
        this.location = in.readString();
        this.image = in.readInt();
        this.code = in.readInt();
    }

    public ItemProduct(String name, String store, String phone, String title, String location, int image) {
        this.name = name;
        this.store = store;
        this.phone = phone;
        this.title = title;
        this.location = location;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", image=" + image +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(store);
        dest.writeString(phone);
        dest.writeString(title);
        dest.writeString(location);
        dest.writeInt(image);
        dest.writeInt(code);
    }
}
