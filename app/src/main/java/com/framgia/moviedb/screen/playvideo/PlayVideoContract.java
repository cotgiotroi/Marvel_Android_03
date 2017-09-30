package com.framgia.moviedb.screen.playvideo;


import com.framgia.moviedb.data.model.Video;
import java.util.List;

/**
 * Created by ducviet on 28/09/2017.
 */

public interface PlayVideoContract {
    interface Presenter{
        void getVideo(int id);
    }
    interface ViewModel{
        void setPresenter(PlayVideoContract.Presenter presenter);
        void onGetVideoSuccess(List<Video> video);
        void onGetVideoFailure(String message);
    }
}
