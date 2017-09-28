package com.framgia.moviedb.screen.genres;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.databinding.ItemGenreBinding;
import com.framgia.moviedb.utils.OnItemClickListener;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public class RecyclerAdapterGenre
        extends RecyclerView.Adapter<RecyclerAdapterGenre.ViewHolderGenres> {
    private List<Genre> mGenres;
    private OnItemClickListener<Genre> mOnItemClickListener;

    public RecyclerAdapterGenre(List<Genre> genres) {
        mGenres = genres;
    }

    @Override
    public ViewHolderGenres onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemGenreBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_genre, parent, false);
        return new ViewHolderGenres(binding, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolderGenres holder, int position) {
        holder.setBindind(mGenres.get(position));
    }

    @Override
    public int getItemCount() {
        return mGenres == null ? 0 : mGenres.size();
    }

    public void setOnItemClickListener(OnItemClickListener<Genre> itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    /**
     * ViewHolder Genre
     */

    class ViewHolderGenres extends RecyclerView.ViewHolder {
        private ItemGenreBinding mBinding;
        private OnItemClickListener<Genre> mClickListener;

        ViewHolderGenres(ItemGenreBinding itemView, OnItemClickListener<Genre> itemClickListener) {
            super(itemView.getRoot());
            mBinding = itemView;
            mClickListener = itemClickListener;
        }

        public void setBindind(Genre genre) {
            if (genre != null) {
                mBinding.setGenre(genre);
                mBinding.setOnItemClick(mClickListener);
            }
        }
    }
}
