package com.framgia.moviedb.screen.movie;

import com.framgia.moviedb.data.model.Movie;
import java.util.List;

/**
 * Created by ducviet on 22/09/2017.
 */

public interface MovieContract {
    /**
     * presenter
     */
    interface Presenter{
        void getMovies(int tab);


    }
    /**
     *  viewmodel
    */
    interface ViewModel{
        void setPresenter(MoviePresenter moviePresenter);
        void onGetMoviesSuccess(List<Movie> movies);
        void onGetMoviesFailure(String message);
    }
}
