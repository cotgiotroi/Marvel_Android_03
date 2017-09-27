package com.framgia.moviedb.data.source.remote.api;

import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.MovieDetail;
import com.framgia.moviedb.data.model.MovieResponse;
import com.framgia.moviedb.data.source.remote.MovieDataResource;
import com.framgia.moviedb.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public class MovieRemoteDataResource extends BaseRemoteDataResource implements MovieDataResource {

    public MovieRemoteDataResource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Movie>> getPopularMovie(String key) {
        return mMovieApi.getPopular(key).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovieList();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getTopRateMovie(String key) {
        return mMovieApi.getTopRate(key).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovieList();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getUpComingMovie(String key) {
        return mMovieApi.getUpComing(key).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovieList();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getNowPlayingMovie(String key) {
        return mMovieApi.getNowPlaying(key).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovieList();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getMovieGenre(int id, String key) {
        return mMovieApi.getMoviesGenres(id, key).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovieList();
            }
        });
    }

    @Override
    public Observable<MovieDetail> getMovieDetail(int id, String key) {
        return mMovieApi.getMovieDetail(id, key);
    }

    @Override
    public Observable<List<Movie>> getMovieCompany(int id, String key) {
        return mMovieApi.getMoviesCompany(id, key).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovieList();
            }
        });
    }
}
