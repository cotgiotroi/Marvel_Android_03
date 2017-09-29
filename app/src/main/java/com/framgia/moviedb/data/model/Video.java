package com.framgia.moviedb.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.moviedb.BR;
import com.google.gson.annotations.SerializedName;


/**
 * Created by ducviet on 28/09/2017.
 */

public class Video extends BaseObservable {
    @SerializedName("key")
    private String mKey;

    @Bindable
    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
        notifyPropertyChanged(BR.key);
    }
}
