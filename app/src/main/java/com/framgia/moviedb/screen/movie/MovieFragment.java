package com.framgia.moviedb.screen.movie;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.moviedb.R;
import com.framgia.moviedb.data.source.remote.MovieDataResource;
import com.framgia.moviedb.data.source.remote.MovieDataRespository;
import com.framgia.moviedb.data.source.remote.api.MovieRemoteDataResource;
import com.framgia.moviedb.data.source.remote.api.service.MovieServiceClient;
import com.framgia.moviedb.databinding.FragmentMovieBinding;

/**
 * A simple {@link MovieFragment} subclass.
 */
public class MovieFragment extends Fragment {
    static final String BUNDLE_POSITION = "position";

    public MovieFragment getInstance(int tab) {
        MovieFragment fragment = new MovieFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_POSITION, tab);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        FragmentMovieBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);
        int tab = getArguments().getInt(BUNDLE_POSITION);
        MovieDataResource movieDataRespository = new MovieDataRespository(
                new MovieRemoteDataResource(MovieServiceClient.getInstance()));
        MovieContract.ViewModel viewModel = new MovieViewModel(getContext(), tab);
        MovieContract.Presenter presenter =
                new MoviePresenter(viewModel, (MovieDataRespository) movieDataRespository);
        viewModel.setPresenter((MoviePresenter) presenter);
        binding.setViewModel((MovieViewModel) viewModel);
        return binding.getRoot();
    }
}
