package com.framgia.moviedb.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.moviedb.BR;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ducviet on 22/09/2017.
 */

public class Actor extends BaseObservable {
    @SerializedName("id")
    private long mIdActor;
    @SerializedName("name")
    private String mNameActor;
    @SerializedName("profile_path")
    private String mProfile;

    @Bindable
    public long getIdActor() {
        return mIdActor;
    }

    public void setIdActor(long idActor) {
        mIdActor = idActor;
        notifyPropertyChanged(BR.idActor);
    }

    @Bindable
    public String getNameActor() {
        return mNameActor;
    }

    public void setNameActor(String nameActor) {
        mNameActor = nameActor;
        notifyPropertyChanged(BR.nameActor);
    }

    @Bindable
    public String getProfile() {
        return mProfile;
    }

    public void setProfile(String profile) {
        mProfile = profile;
        notifyPropertyChanged(BR.profile);
    }
}
