package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.source.remote.api.ActorRemoteDataResource;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public class ActorDataRepository implements ActorDataResource {
    private ActorRemoteDataResource mResource;

    public ActorDataRepository(ActorRemoteDataResource resource) {
        mResource = resource;
    }

    @Override
    public Observable<List<Actor>> getActorsMovie(int id, String key) {
        return mResource.getActorsMovie(id, key);
    }
}
