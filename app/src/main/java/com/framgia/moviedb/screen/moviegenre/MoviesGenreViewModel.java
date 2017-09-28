package com.framgia.moviedb.screen.moviegenre;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.movie.RecyclerAdapterMovie;
import com.framgia.moviedb.screen.moviedetail.MovieDetailActivity;
import com.framgia.moviedb.utils.OnItemClickListener;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public class MoviesGenreViewModel extends BaseObservable
        implements MoviesGenreContract.ViewModel, OnItemClickListener<Movie> {
    public static final int ITEM_REC = 2;
    private MoviesGenreContract.Presenter mPresenter;
    private Context mContext;
    private RecyclerAdapterMovie mAdapterMovie;
    private String mTitle;
    private int mId;
    private boolean mIsCheck;

    public MoviesGenreViewModel(Context context, String title, int id) {
        mContext = context;
        mTitle = title;
        mId = id;
    }

    @Bindable
    public boolean isCheck() {
        return mIsCheck;
    }

    public void setCheck(boolean check) {
        mIsCheck = check;
        notifyPropertyChanged(BR.check);
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
        notifyPropertyChanged(BR.title);
    }

    @Override
    public void setPresenter(MoviesGenrePresenter presenter) {
        mPresenter = presenter;
        mPresenter.getMoviesGenre(mId);
    }

    @Bindable
    public RecyclerAdapterMovie getAdapterMovie() {
        return mAdapterMovie;
    }

    public void setAdapterMovie(RecyclerAdapterMovie adapterMovie) {
        mAdapterMovie = adapterMovie;
        notifyPropertyChanged(BR.adapterMovie);
    }

    @Override
    public void onGetMoviesGenreSuccess(List<Movie> movies) {

        setCheck(true);
        mAdapterMovie = new RecyclerAdapterMovie(mContext, movies);
        mAdapterMovie.setOnClickItemListener(this);
        setAdapterMovie(mAdapterMovie);
    }

    @Override
    public void onGetMoviesGnereFailure(String message) {
        Toast.makeText(mContext, mContext.getResources().getString(R.string.error) + message,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(Movie movie) {
        mContext.startActivity(MovieDetailActivity.getInstance(mContext, movie.getId()));
    }
}
