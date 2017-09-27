package com.framgia.moviedb.data.source.remote;


import com.framgia.moviedb.data.model.Actor;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public interface ActorDataResource  {
    Observable<List<Actor>> getActorsMovie(int id, String key);
}
