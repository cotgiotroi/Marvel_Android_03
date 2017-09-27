package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Genre;

import com.framgia.moviedb.data.source.remote.api.GenreRemoteDataResource;
import io.reactivex.Observable;

import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public class GenreDataRespository implements GenreDataResource {
    private GenreRemoteDataResource mResource;

    public GenreDataRespository(GenreRemoteDataResource resource) {
        mResource = resource;
    }

    @Override
    public Observable<List<Genre>> getGenres(String key) {

        return mResource.getGenres(key);
    }
}
