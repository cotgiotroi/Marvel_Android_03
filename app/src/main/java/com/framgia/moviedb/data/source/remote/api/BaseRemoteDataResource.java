package com.framgia.moviedb.data.source.remote.api;

import com.framgia.moviedb.data.source.remote.api.service.MovieApi;

/**
 * Created by ducviet on 22/09/2017.
 */

public abstract class BaseRemoteDataResource {
    MovieApi mMovieApi;

    public BaseRemoteDataResource(MovieApi movieApi) {
        mMovieApi = movieApi;
    }
}
