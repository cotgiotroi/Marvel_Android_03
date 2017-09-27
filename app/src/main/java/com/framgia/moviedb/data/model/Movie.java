package com.framgia.moviedb.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.moviedb.BR;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ducviet on 21/09/2017.
 */

public class Movie extends BaseObservable {
    @SerializedName("id")
    private long mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("backdrop_path")
    private String mBackground;

    @Bindable
    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getBackground() {
        return mBackground;
    }

    public void setBackground(String background) {
        mBackground = background;
        notifyPropertyChanged(BR.background);
    }
}
