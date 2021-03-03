package com.example.digitalenttraining;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserModel(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeInt(this.age);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.address = source.readString();
        this.age = source.readInt();
    }

    protected UserModel(Parcel in) {
        this.name = in.readString();
        this.address = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
