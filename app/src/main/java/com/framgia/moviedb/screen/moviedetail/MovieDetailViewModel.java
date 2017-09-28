package com.framgia.moviedb.screen.moviedetail;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.MovieDetail;

/**
 * Created by ducviet on 27/09/2017.
 */

public class MovieDetailViewModel extends BaseObservable implements MovieDetailContract.ViewModel {
    private MovieDetailContract.Presenter mPresenter;
    private Context mContext;
    private MovieDetail mMovieDetail;
    private int mId;

    public MovieDetailViewModel(Context context, int id) {
        mContext = context;
        mId = id;
    }

    @Bindable
    public MovieDetail getMovieDetail() {
        return mMovieDetail;
    }

    public void setMovieDetail(MovieDetail movieDetail) {
        mMovieDetail = movieDetail;
        notifyPropertyChanged(BR.movieDetail);
    }

    @Override
    public void setPresenter(MovieDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onGetMovieDetailSuccess(MovieDetail movie) {
        setMovieDetail(movie);
    }

    @Override
    public void onGetMovieDetailFailure(String message) {
        Toast.makeText(mContext, mContext.getResources().getString(R.string.error) + message,
                Toast.LENGTH_LONG).show();
    }
}
