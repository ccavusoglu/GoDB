package com.godb.app.presentation.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
public class Announcement implements Parcelable {
    protected Announcement(Parcel in) {
    }

    public static final Creator<Announcement> CREATOR = new Creator<Announcement>() {
        @Override
        public Announcement createFromParcel(Parcel in) {
            return new Announcement(in);
        }

        @Override
        public Announcement[] newArray(int size) {
            return new Announcement[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
