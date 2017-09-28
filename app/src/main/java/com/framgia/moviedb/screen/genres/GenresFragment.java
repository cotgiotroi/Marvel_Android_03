package com.framgia.moviedb.screen.genres;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.moviedb.R;
import com.framgia.moviedb.data.source.remote.GenreDataResource;
import com.framgia.moviedb.data.source.remote.GenreDataRespository;
import com.framgia.moviedb.data.source.remote.api.GenreRemoteDataResource;
import com.framgia.moviedb.data.source.remote.api.service.MovieServiceClient;
import com.framgia.moviedb.databinding.FragmentGenresBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenresFragment extends Fragment {

    public GenresFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        FragmentGenresBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_genres, container, false);
        GenreDataResource genreDataRespository = new GenreDataRespository(
                new GenreRemoteDataResource(MovieServiceClient.getInstance()));
        GenresContract.ViewModel viewModel = new GenresViewModel(getContext());
        GenresContract.Presenter presenter =
                new GenresPresenter(viewModel, (GenreDataRespository) genreDataRespository);
        viewModel.setPresenter((GenresPresenter) presenter);
        binding.setViewModel((GenresViewModel) viewModel);
        return binding.getRoot();
    }
}
