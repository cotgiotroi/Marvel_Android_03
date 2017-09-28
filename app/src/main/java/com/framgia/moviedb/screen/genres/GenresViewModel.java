package com.framgia.moviedb.screen.genres;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.screen.moviegenre.MoviesGenreActivity;
import com.framgia.moviedb.utils.OnItemClickListener;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public class GenresViewModel extends BaseObservable
        implements GenresContract.ViewModel, OnItemClickListener<Genre> {

    private GenresContract.Presenter mPresenter;
    private RecyclerAdapterGenre mAdapterGenre;
    private Context mContext;
    private boolean mIsLoad;

    public GenresViewModel(Context context) {
        mContext = context;
    }

    @Bindable
    public RecyclerAdapterGenre getAdapterGenre() {
        return mAdapterGenre;
    }

    public void setAdapterGenre(RecyclerAdapterGenre adapterGenre) {
        mAdapterGenre = adapterGenre;
        notifyPropertyChanged(BR.adapterGenre);
    }

    @Bindable
    public boolean isLoad() {
        return mIsLoad;
    }

    public void setLoad(boolean load) {
        mIsLoad = load;
        notifyPropertyChanged(BR.load);
    }

    @Override
    public void setPresenter(GenresPresenter presenter) {
        mPresenter = presenter;
        mPresenter.getGenres();
    }

    @Override
    public void onGetGenresSuccess(List<Genre> genres) {
        setLoad(true);
        mAdapterGenre = new RecyclerAdapterGenre(genres);
        mAdapterGenre.setOnItemClickListener(this);
        setAdapterGenre(mAdapterGenre);
    }

    @Override
    public void onGetGenresFailure(String message) {
        Toast.makeText(mContext, mContext.getResources().getString(R.string.error) + message,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(Genre genre) {
        mContext.startActivity(MoviesGenreActivity.getInstance(mContext, genre));
    }
}
