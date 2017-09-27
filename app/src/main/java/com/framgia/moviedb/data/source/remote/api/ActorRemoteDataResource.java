package com.framgia.moviedb.data.source.remote.api;

import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.ActorResponse;
import com.framgia.moviedb.data.source.remote.ActorDataResource;
import com.framgia.moviedb.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public class ActorRemoteDataResource extends BaseRemoteDataResource implements ActorDataResource {
    public ActorRemoteDataResource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Actor>> getActorsMovie(int id, String key) {
        return mMovieApi.getActors(id, key).map(new Function<ActorResponse, List<Actor>>() {
            @Override
            public List<Actor> apply(ActorResponse actorResponse) throws Exception {
                return actorResponse.getActors();
            }
        });
    }
}
