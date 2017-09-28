package com.framgia.moviedb.screen.moviegenre;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.remote.MovieDataRespository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public class MoviesGenrePresenter implements MoviesGenreContract.Presenter {
    private MovieDataRespository mRespository;
    private MoviesGenreContract.ViewModel mViewModel;
    private CompositeDisposable mDisposable;

    public MoviesGenrePresenter(MovieDataRespository respository,
            MoviesGenreContract.ViewModel viewModel) {
        mRespository = respository;
        mViewModel = viewModel;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void getMoviesGenre(int id) {
        mDisposable.add(mRespository.getMovieGenre(id, BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Movie>>() {
                    @Override
                    public void onNext(List<Movie> value) {
                        mViewModel.onGetMoviesGenreSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetMoviesGnereFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
