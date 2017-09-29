package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Video;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by ducviet on 29/09/2017.
 */

public interface VideoDataResource {
    Observable<List<Video>> getVideo(int id, String key);
}
