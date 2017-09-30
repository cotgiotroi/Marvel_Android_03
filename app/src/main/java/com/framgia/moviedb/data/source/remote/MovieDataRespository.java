package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.MovieDetail;

import io.reactivex.Observable;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public class MovieDataRespository implements MovieDataResource {
    private MovieDataResource mResource;

    public MovieDataRespository(MovieDataResource resource) {
        mResource = resource;
    }

    @Override
    public Observable<List<Movie>> getPopularMovie(String key) {
        return mResource.getPopularMovie(key);
    }

    @Override
    public Observable<List<Movie>> getTopRateMovie(String key) {
        return mResource.getTopRateMovie(key);
    }

    @Override
    public Observable<List<Movie>> getUpComingMovie(String key) {
        return mResource.getUpComingMovie(key);
    }

    @Override
    public Observable<List<Movie>> getNowPlayingMovie(String key) {
        return mResource.getNowPlayingMovie(key);
    }

    @Override
    public Observable<List<Movie>> getMovieGenre(int id, String key) {
        return mResource.getMovieGenre(id, key);
    }

    @Override
    public Observable<MovieDetail> getMovieDetail(int id, String key) {
        return mResource.getMovieDetail(id, key);
    }

    @Override
    public Observable<List<Movie>> getMovieCompany(int id, String key) {
        return mResource.getMovieCompany(id, key);
    }

    @Override
    public Observable<List<Movie>> getMoviesSimilar(int id, String key) {
        return mResource.getMoviesSimilar(id,key);
    }
}
