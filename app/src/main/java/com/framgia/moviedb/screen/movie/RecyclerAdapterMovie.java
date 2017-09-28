package com.framgia.moviedb.screen.movie;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.databinding.ItemMovieBinding;
import com.framgia.moviedb.utils.OnItemClickListener;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public class RecyclerAdapterMovie
        extends RecyclerView.Adapter<RecyclerAdapterMovie.ViewHolderMovie> {
    private List<Movie> mMovies;
    private Context mContext;
    private OnItemClickListener<Movie> mListener;

    public RecyclerAdapterMovie(Context context, List<Movie> movies) {
        mMovies = movies;
        mContext = context;
    }

    @Override
    public ViewHolderMovie onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMovieBinding movieBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_movie, parent, false);
        return new ViewHolderMovie(movieBinding, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderMovie holder, int position) {
        holder.setMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies == null ? 0 : mMovies.size();
    }

    public void setOnClickItemListener(OnItemClickListener<Movie> itemListener) {
        mListener = itemListener;
    }

    /**
     * viewholder movie
     */

    class ViewHolderMovie extends RecyclerView.ViewHolder {
        private ItemMovieBinding mBinding;
        private OnItemClickListener<Movie> mOnItemClickListener;

        ViewHolderMovie(ItemMovieBinding itemView, OnItemClickListener<Movie> itemClickListener) {
            super(itemView.getRoot());
            mBinding = itemView;
            mOnItemClickListener = itemClickListener;
        }

        public void setMovie(Movie movie) {
            if (movie != null) {
                mBinding.setMovie(movie);
                mBinding.setOnItemClick(mOnItemClickListener);
                mBinding.executePendingBindings();
            }
        }
    }
}
