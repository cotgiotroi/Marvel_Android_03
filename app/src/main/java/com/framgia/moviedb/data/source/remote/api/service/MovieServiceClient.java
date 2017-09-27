package com.framgia.moviedb.data.source.remote.api.service;

import com.framgia.moviedb.utils.Constant;

/**
 * Created by ducviet on 22/09/2017.
 */

public class MovieServiceClient extends ServiceClient {
    private static MovieApi mMovieApi;

    public static MovieApi getInstance() {
        if (mMovieApi == null) {
            mMovieApi = ServiceClient.createService(Constant.MOVIE_API, MovieApi.class);
        }
        return mMovieApi;
    }
}
