package com.framgia.moviedb.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public class MovieResponse  {
    @SerializedName("results")
    private List<Movie> mMovieList;

    public List<Movie> getMovieList() {
        return mMovieList;
    }

    public void setMovieList(List<Movie> movieList) {
        mMovieList = movieList;
    }
}
