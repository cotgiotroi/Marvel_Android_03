package com.framgia.moviedb.screen.movie;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.remote.MovieDataRespository;
import com.framgia.moviedb.utils.Constant;
import io.reactivex.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public class MoviePresenter implements MovieContract.Presenter {
    private MovieContract.ViewModel mViewModel;
    private MovieDataRespository mRespository;
    private CompositeDisposable mDisposable;

    public MoviePresenter(MovieContract.ViewModel viewModel, MovieDataRespository respository) {
        mViewModel = viewModel;
        mRespository = respository;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void getMovies(int tab) {
        Observable<List<Movie>> observable = null;
        switch (tab) {
            case Constant.POPULAR:
                observable = mRespository.getPopularMovie(BuildConfig.API_KEY);
                break;
            case Constant.UP_COMING:
                observable = mRespository.getUpComingMovie(BuildConfig.API_KEY);
                break;
            case Constant.TOP_RATE:
                observable = mRespository.getTopRateMovie(BuildConfig.API_KEY);
                break;
            case Constant.NOW_PLAYING:
                observable = mRespository.getNowPlayingMovie(BuildConfig.API_KEY);
                break;
            default:
                observable = mRespository.getPopularMovie(BuildConfig.API_KEY);
                break;
        }
        mDisposable.add(observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Movie>>() {
                    @Override
                    public void onNext(List<Movie> value) {
                        mViewModel.onGetMoviesSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetMoviesFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
