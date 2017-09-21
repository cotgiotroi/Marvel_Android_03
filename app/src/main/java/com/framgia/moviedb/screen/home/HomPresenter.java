package com.framgia.moviedb.screen.home;

/**
 * Created by ducviet on 20/09/2017.
 */

public class HomPresenter implements HomeContract.Presenter {
    private HomeContract.ViewModel mViewModel;

    public HomPresenter(HomeViewModel viewModel) {
        mViewModel = viewModel;
    }
}
