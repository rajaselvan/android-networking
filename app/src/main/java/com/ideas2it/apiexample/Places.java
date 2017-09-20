package com.ideas2it.apiexample;


import android.os.Parcel;
import android.os.Parcelable;

public class Places implements Parcelable {

  private String name;

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

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  private String address;
  private String date;
  private String imageUrl;

  public Places(){}

  public Places(Parcel in) {
    this.name = in.readString();
    this.address = in.readString();
    this.date = in.readString();
    this.imageUrl = in.readString();
  }

  public Places(String name, String address, String date, String imageUrl) {
    this.name = name;
    this.address = address;
    this.date = date;
    this.imageUrl = imageUrl;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeString(address);
    dest.writeString(date);
    dest.writeString(imageUrl);
  }

  public static final Creator CREATOR = new Creator() {
    public Places createFromParcel(Parcel in) {
      return new Places(in);
    }

    public Places[] newArray(int size) {
      return new Places[size];
    }
  };
}

