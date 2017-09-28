package com.framgia.moviedb.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import com.framgia.moviedb.BR;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ducviet on 21/09/2017.
 */

public class Genre extends BaseObservable implements Parcelable {
    @SerializedName("id")
    private long mId;
    @SerializedName("name")
    private String mName;

    protected Genre(Parcel in) {
        mId = in.readLong();
        mName = in.readString();
    }

    public static final Creator<Genre> CREATOR = new Creator<Genre>() {
        @Override
        public Genre createFromParcel(Parcel in) {
            return new Genre(in);
        }

        @Override
        public Genre[] newArray(int size) {
            return new Genre[size];
        }
    };

    @Bindable
    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mId);
        parcel.writeString(mName);
    }
}
