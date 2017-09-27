package com.framgia.moviedb.screen.movie;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.databinding.ItemMovieBinding;

import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public class RecyclerAdapterMovie
        extends RecyclerView.Adapter<RecyclerAdapterMovie.ViewHolderMovie> {
    private List<Movie> mMovies;
    private Context mContext;
    private OnItemClickListener mClickListener;

    public RecyclerAdapterMovie(Context context, List<Movie> movies) {
        mMovies = movies;
        mContext = context;
    }

    @Override
    public ViewHolderMovie onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMovieBinding movieBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_movie, parent, false);
        return new ViewHolderMovie(movieBinding, mClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderMovie holder, int position) {
        holder.setMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies == null ? 0 : mMovies.size();
    }

    /**
     * viewholder movie
     */

    class ViewHolderMovie extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemMovieBinding mBinding;
        private OnItemClickListener onItemClickListener;
        private Movie mMovie;

        ViewHolderMovie(ItemMovieBinding itemView, OnItemClickListener itemClickListener) {
            super(itemView.getRoot());
            mBinding = itemView;
            onItemClickListener = itemClickListener;
            itemView.getRoot().setOnClickListener(this);
        }

        public void setMovie(final Movie movie) {
            if (movie != null) {
                mMovie = movie;
                mBinding.setMovie(movie);
            }
        }

        @Override
        public void onClick(View view) {
            this.onItemClickListener.onClick(mMovie);
        }
    }

    /**
     * OnClickItem RecyclerView
     */
    public interface OnItemClickListener {
        void onClick(Movie movie);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mClickListener = onItemClickListener;
    }
}
