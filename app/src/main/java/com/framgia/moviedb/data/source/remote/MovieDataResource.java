package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.MovieDetail;

import io.reactivex.Observable;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public interface MovieDataResource {
    Observable<List<Movie>> getPopularMovie(String key);

    Observable<List<Movie>> getTopRateMovie(String key);

    Observable<List<Movie>> getUpComingMovie(String key);

    Observable<List<Movie>> getNowPlayingMovie(String key);

    Observable<List<Movie>> getMovieGenre(int id, String key);

    Observable<MovieDetail> getMovieDetail(int id, String key);

    Observable<List<Movie>> getMovieCompany(int id, String key);

    Observable<List<Movie>> getMoviesSimilar(int id, String key);
}
