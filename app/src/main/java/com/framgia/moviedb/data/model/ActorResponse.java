package com.framgia.moviedb.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public class ActorResponse {
    @SerializedName("cast")
    private List<Actor> mActors;

    public List<Actor> getActors() {
        return mActors;
    }

    public void setActors(List<Actor> actors) {
        mActors = actors;
    }
}
