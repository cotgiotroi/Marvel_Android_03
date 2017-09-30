package com.framgia.moviedb.data.source.remote.api.service;

import com.framgia.moviedb.data.model.ActorResponse;
import com.framgia.moviedb.data.model.GenreResponse;
import com.framgia.moviedb.data.model.MovieDetail;
import com.framgia.moviedb.data.model.MovieResponse;
import com.framgia.moviedb.data.model.VideoResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ducviet on 22/09/2017.
 */

public interface MovieApi {
    static final String API_KEY = "api_key";

    @GET("movie/popular")
    Observable<MovieResponse> getPopular(@Query(API_KEY) String api);

    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRate(@Query(API_KEY) String api);

    @GET("movie/upcoming")
    Observable<MovieResponse> getUpComing(@Query(API_KEY) String api);

    @GET("movie/now_playing")
    Observable<MovieResponse> getNowPlaying(@Query(API_KEY) String api);

    @GET("genre/movie/list")
    Observable<GenreResponse> getGenres(@Query(API_KEY) String api);

    @GET("genre/{genre_id}/movies")
    Observable<MovieResponse> getMoviesGenres(@Path("genre_id") int id, @Query(API_KEY) String api);

    @GET("movie/{movie_id}")
    Observable<MovieDetail> getMovieDetail(@Path("movie_id") int id, @Query(API_KEY) String api);

    @GET("company/{company_id}/movies")
    Observable<MovieResponse> getMoviesCompany(@Path("company_id") int id,
            @Query(API_KEY) String api);

    @GET("movie/{movie_id}/credits")
    Observable<ActorResponse> getActors(@Path("movie_id") int id, @Query(API_KEY) String api);

    @GET("movie/{movie_id}/videos")
    Observable<VideoResponse> getVideo(@Path("movie_id") int id, @Query(API_KEY) String api);

    @GET("movie/{movie_id}/similar")
    Observable<MovieResponse> getMoviesSimilar(@Path("movie_id") int id,
            @Query(API_KEY) String api);
}
