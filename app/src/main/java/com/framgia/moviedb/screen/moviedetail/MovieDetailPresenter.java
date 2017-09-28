package com.framgia.moviedb.screen.moviedetail;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.MovieDetail;
import com.framgia.moviedb.data.source.remote.MovieDataRespository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ducviet on 27/09/2017.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter {
    private MovieDetailContract.ViewModel mViewModel;
    private MovieDataRespository mRespository;
    private CompositeDisposable mDisposable;

    public MovieDetailPresenter(MovieDetailContract.ViewModel viewModel,
            MovieDataRespository respository) {
        mViewModel = viewModel;
        mRespository = respository;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void getMovieDetail(int id) {
        mDisposable.add(mRespository.getMovieDetail(id, BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MovieDetail>() {
                    @Override
                    public void onNext(MovieDetail value) {
                        mViewModel.onGetMovieDetailSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetMovieDetailFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}

