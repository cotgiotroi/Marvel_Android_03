package com.framgia.moviedb.screen.genres;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.source.remote.GenreDataRespository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public class GenresPresenter implements GenresContract.Presenter {
    private GenresContract.ViewModel mViewModel;
    private GenreDataRespository mRespository;
    private CompositeDisposable mDisposable;

    public GenresPresenter(GenresContract.ViewModel viewModel, GenreDataRespository respository) {
        mViewModel = viewModel;
        mRespository = respository;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void getGenres() {
        mDisposable.add(mRespository.getGenres(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Genre>>() {
                    @Override
                    public void onNext(List<Genre> value) {
                        mViewModel.onGetGenresSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetGenresFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
