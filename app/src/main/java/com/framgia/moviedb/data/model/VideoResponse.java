package com.framgia.moviedb.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.moviedb.BR;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by ducviet on 28/09/2017.
 */

public class VideoResponse extends BaseObservable {
    @SerializedName("results")
    private List<Video> mVideo;

    @Bindable
    public List<Video> getVideo() {
        return mVideo;
    }

    public void setVideo(List<Video> video) {
        mVideo = video;
        notifyPropertyChanged(BR.video);
    }
}
