package com.framgia.moviedb.data.source.remote.api;

import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.model.GenreResponse;
import com.framgia.moviedb.data.source.remote.GenreDataResource;
import com.framgia.moviedb.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public class GenreRemoteDataResource extends BaseRemoteDataResource implements GenreDataResource {
    public GenreRemoteDataResource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Genre>> getGenres(String key) {
        return mMovieApi.getGenres(key).map(new Function<GenreResponse, List<Genre>>() {
            @Override
            public List<Genre> apply(GenreResponse genreResponse) throws Exception {
                return genreResponse.getGenres();
            }
        });
    }
}
