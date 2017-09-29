package com.framgia.moviedb.data.source.remote.api;

import com.framgia.moviedb.data.model.Video;
import com.framgia.moviedb.data.model.VideoResponse;
import com.framgia.moviedb.data.source.remote.VideoDataResource;
import com.framgia.moviedb.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by ducviet on 29/09/2017.
 */

public class VideoRemoteDataResource extends BaseRemoteDataResource implements VideoDataResource {
    public VideoRemoteDataResource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Video>> getVideo(int id, String key) {
        return mMovieApi.getVideo(id, key).map(new Function<VideoResponse, List<Video>>() {
            @Override
            public List<Video> apply(VideoResponse videoResponse) throws Exception {
                return videoResponse.getVideo();
            }
        });
    }
}
