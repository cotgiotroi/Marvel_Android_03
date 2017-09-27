package com.framgia.moviedb.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.moviedb.BR;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public class MovieDetail extends BaseObservable {
    @SerializedName("genres")
    private List<Genre> mGenresMovie;
    @SerializedName("id")
    private long mIdMovie;
    @SerializedName("original_title")
    private String mNameMovie;
    @SerializedName("overview")
    private String mOverviewMovie;
    @SerializedName("backdrop_path")
    private String mBackdropMovie;
    @SerializedName("poster_path")
    private String mPosterMovie;
    @SerializedName("production_companies")
    private List<Company> mCompanies;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("vote_average")
    private float mVoteAvgMovie;
    @SerializedName("vote_count")
    private long mVoteCount;

    @Bindable
    public List<Genre> getGenresMovie() {
        return mGenresMovie;
    }

    public void setGenresMovie(List<Genre> genresMovie) {
        mGenresMovie = genresMovie;
        notifyPropertyChanged(BR.genresMovie);
    }

    @Bindable
    public long getIdMovie() {
        return mIdMovie;
    }

    public void setMovie(long idMovie) {
        mIdMovie = idMovie;
        notifyPropertyChanged(BR.idMovie);
    }

    @Bindable
    public String getNameMovie() {
        return mNameMovie;
    }

    public void setNameMovie(String nameMovie) {
        mNameMovie = nameMovie;
        notifyPropertyChanged(BR.nameMovie);
    }

    @Bindable
    public String getOverviewMovie() {
        return mOverviewMovie;
    }

    public void setMverviewMovie(String mverviewMovie) {
        this.mOverviewMovie = mverviewMovie;
        notifyPropertyChanged(BR.overviewMovie);
    }

    @Bindable
    public String getBackdropMovie() {
        return mBackdropMovie;
    }

    public void setBackdropMovie(String backdropMovie) {
        mBackdropMovie = backdropMovie;
        notifyPropertyChanged(BR.backdropMovie);
    }

    @Bindable
    public String getPosterMovie() {
        return mPosterMovie;
    }

    public void setPosterMovie(String posterMovie) {
        mPosterMovie = posterMovie;
        notifyPropertyChanged(BR.posterMovie);
    }

    @Bindable
    public List<Company> getCompanies() {
        return mCompanies;
    }

    public void setCompanies(List<Company> companies) {
        mCompanies = companies;
        notifyPropertyChanged(BR.companies);
    }

    @Bindable
    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
        notifyPropertyChanged(BR.releaseDate);
    }

    @Bindable
    public float getVoteAvgMovie() {
        return mVoteAvgMovie;
    }

    public void setVoteAvgMovie(float voteAvgMovie) {
        mVoteAvgMovie = voteAvgMovie;
        notifyPropertyChanged(BR.voteAvgMovie);
    }

    @Bindable
    public long getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(long voteCount) {
        mVoteCount = voteCount;
        notifyPropertyChanged(BR.voteCount);
    }
}
