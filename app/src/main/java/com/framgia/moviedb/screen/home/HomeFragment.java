package com.framgia.moviedb.screen.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.moviedb.R;
import com.framgia.moviedb.databinding.FragmentHomeFilmBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        FragmentHomeFilmBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_home_film, container, false);
        HomeContract.ViewModel viewModel =
                new HomeViewModel(getContext(), getChildFragmentManager());
        HomeContract.Presenter presenter = new HomPresenter((HomeViewModel) viewModel);
        viewModel.setPresenter((HomPresenter) presenter);
        binding.setViewModel((HomeViewModel) viewModel);
        return binding.getRoot();
    }
}
