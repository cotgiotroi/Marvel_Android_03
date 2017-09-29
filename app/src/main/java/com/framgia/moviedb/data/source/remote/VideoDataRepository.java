package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Video;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by ducviet on 29/09/2017.
 */

public class VideoDataRepository implements VideoDataResource {
    private VideoDataResource mVideoDataResource;

    public VideoDataRepository(VideoDataResource videoDataResource) {
        mVideoDataResource = videoDataResource;
    }

    @Override
    public Observable<List<Video>> getVideo(int id, String key) {
        return mVideoDataResource.getVideo(id, key);
    }
}
