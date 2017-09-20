package com.framgia.moviedb.screen.main;

/**
 * Created by ducviet on 20/09/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.ViewModel mViewModel;

    public MainPresenter(MainViewModel viewModel) {
        mViewModel = viewModel;
    }
}
