package com.framgia.moviedb.screen.playvideo;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Video;
import com.framgia.moviedb.data.source.remote.VideoDataRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Created by ducviet on 28/09/2017.
 */

public class PlayVideoPresenter implements PlayVideoContract.Presenter {
    private PlayVideoContract.ViewModel mViewModel;
    private VideoDataRepository mVideoDataRepository;
    private CompositeDisposable mDisposable;

    public PlayVideoPresenter(PlayVideoContract.ViewModel viewModel,
            VideoDataRepository videoDataRepository) {
        mViewModel = viewModel;
        mVideoDataRepository = videoDataRepository;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void getVideo(int id) {
        mDisposable.add(mVideoDataRepository.getVideo(id, BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Video>>() {
                    @Override
                    public void onNext(List<Video> value) {
                        mViewModel.onGetVideoSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetVideoFailure(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
