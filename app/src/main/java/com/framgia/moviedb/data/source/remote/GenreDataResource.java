package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Genre;

import io.reactivex.Observable;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public interface GenreDataResource {
    Observable<List<Genre>> getGenres(String key);
}
