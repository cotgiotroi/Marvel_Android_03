package com.framgia.moviedb.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.moviedb.BR;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ducviet on 22/09/2017.
 */

public class Company extends BaseObservable {
    @SerializedName("name")
    private String mNameCompany;
    @SerializedName("id")
    private long mIdCompany;

    @Bindable
    public String getNameCompany() {
        return mNameCompany;
    }

    public void setNameCompany(String nameCompany) {
        mNameCompany = nameCompany;
        notifyPropertyChanged(BR.nameCompany);
    }

    @Bindable
    public long getIdCompany() {
        return mIdCompany;
    }

    public void setIdCompany(long idCompany) {
        mIdCompany = idCompany;
        notifyPropertyChanged(BR.idCompany);
    }
}
