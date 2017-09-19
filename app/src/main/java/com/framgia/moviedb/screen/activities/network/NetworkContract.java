package com.framgia.moviedb.screen.activities.network;

/**
 * Created by ducviet on 17/09/2017.
 */

public interface NetworkContract {
    interface NetworkPresenter {
        void onCheckNetwork();
    }

    interface NetworkViewModel {
        void onSuccess();

        void onError();
    }
}
