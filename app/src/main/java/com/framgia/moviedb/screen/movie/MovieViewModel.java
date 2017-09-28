package com.framgia.moviedb.screen.movie;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.moviedetail.MovieDetailActivity;
import com.framgia.moviedb.utils.OnItemClickListener;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public class MovieViewModel extends BaseObservable
        implements MovieContract.ViewModel, OnItemClickListener<Movie> {

    public static final int ITEM_REC = 2;
    private MovieContract.Presenter mPresenter;
    private boolean mIsCheck;
    private Context mContext;
    private RecyclerAdapterMovie mAdapterMovie;
    private int mTab;

    public MovieViewModel(Context context, int tab) {
        mContext = context;
        mTab = tab;
    }

    @Bindable
    public RecyclerAdapterMovie getAdapterMovie() {
        return mAdapterMovie;
    }

    public void setAdapterMovie(RecyclerAdapterMovie adapterMovie) {
        mAdapterMovie = adapterMovie;
        notifyPropertyChanged(BR.adapterMovie);
    }

    @Bindable
    public boolean getCheck() {
        return mIsCheck;
    }

    public void setCheck(boolean check) {
        mIsCheck = check;
        notifyPropertyChanged(BR.check);
    }

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getMovies(mTab);
    }

    @Override
    public void onGetMoviesSuccess(List<Movie> movies) {
        setCheck(true);
        mAdapterMovie = new RecyclerAdapterMovie(mContext, movies);
        mAdapterMovie.setOnClickItemListener(this);
        setAdapterMovie(mAdapterMovie);
    }

    @Override
    public void onGetMoviesFailure(String message) {
        Toast.makeText(mContext, mContext.getResources().getString(R.string.error) + message,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(Movie movie) {
        mContext.startActivity(MovieDetailActivity.getInstance(mContext, movie.getId()));
    }
}
