package com.framgia.moviedb.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.moviedb.BR;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ducviet on 21/09/2017.
 */

public class Genre extends BaseObservable {
    @SerializedName("id")
    private long mId;
    @SerializedName("name")
    private String mName;

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
}
