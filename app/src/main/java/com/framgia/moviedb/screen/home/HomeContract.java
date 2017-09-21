package com.framgia.moviedb.screen.home;

/**
 * Created by ducviet on 20/09/2017.
 */

public interface HomeContract {
    /**
     * presenter
     */
    interface Presenter {

    }

    /**
     * viewmodel
     */
    interface ViewModel {
        void setPresenter(HomPresenter presenter);
    }
}
