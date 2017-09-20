package com.framgia.moviedb.screen.network;

/**
 * Created by ducviet on 17/09/2017.
 */

public interface NetworkContract {
    /*
    * network presenter
    */
    interface NetworkPresenter {
        void onCheckNetwork();
    }
/*
* network viewodel*/
    interface NetworkViewModel {
        void onSuccess();

        void onError();
    }
}
