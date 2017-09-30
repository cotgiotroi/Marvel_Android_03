package com.framgia.moviedb.screen.playvideo;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Video;
import java.util.List;

/**
 * Created by ducviet on 28/09/2017.
 */

public class PlayVieoViewModel extends BaseObservable implements PlayVideoContract.ViewModel {
    private PlayVideoContract.Presenter mPresenter;
    private int mIdMovie;
    private String mIdVideo;
    private Context mContext;

    public PlayVieoViewModel(Context context, int idMovie) {
        mContext = context;
        mIdMovie = idMovie;
    }

    @Bindable
    public String getIdVideo() {
        return mIdVideo;
    }

    public void setIdVideo(String idVideo) {
        mIdVideo = idVideo;
        notifyPropertyChanged(BR.idVideo);
    }

    @Override
    public void setPresenter(PlayVideoContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getVideo(mIdMovie);
    }

    @Override
    public void onGetVideoSuccess(List<Video> videos) {

        setIdVideo(videos.get(0).getKey());
    }

    @Override
    public void onGetVideoFailure(String message) {
        Toast.makeText(mContext, mContext.getResources().getString(R.string.error) + message,
                Toast.LENGTH_LONG).show();
    }
}
