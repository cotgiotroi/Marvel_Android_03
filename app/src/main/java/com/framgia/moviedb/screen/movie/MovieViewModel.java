package com.framgia.moviedb.screen.movie;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.moviedetail.MovieDetailActivity;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public class MovieViewModel extends BaseObservable
        implements MovieContract.ViewModel, RecyclerAdapterMovie.OnItemClickListener {
    private MovieContract.Presenter mPresenter;
    private Boolean isCheck;
    private Context mContext;
    public static final int ITEM_REC = 2;
    public static final String EXTRA_ID_MOVIE = "id";
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
    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
        notifyPropertyChanged(BR.check);
    }

    @Override
    public void setPresenter(MoviePresenter presenter) {
        mPresenter = presenter;
        mPresenter.getMovies(mTab);
    }

    @Override
    public void onGetMoviesSuccess(List<Movie> movies) {
        setCheck(true);
        mAdapterMovie = new RecyclerAdapterMovie(mContext, movies);
        mAdapterMovie.setOnItemClickListener(this);
        setAdapterMovie(mAdapterMovie);
    }

    @Override
    public void onGetMoviesFailure(String message) {

    }

    @Override
    public void onClick(Movie movie) {
        Intent i = new Intent(mContext, MovieDetailActivity.class);
        i.putExtra(EXTRA_ID_MOVIE, movie.getId());
        mContext.startActivity(i);
    }
}
