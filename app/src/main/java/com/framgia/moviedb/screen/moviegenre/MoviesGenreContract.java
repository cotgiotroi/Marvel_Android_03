package com.framgia.moviedb.screen.moviegenre;

import com.framgia.moviedb.data.model.Movie;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public interface MoviesGenreContract {
    /**
     * Presenter MoviesGenre
     */
    interface Presenter {
        void getMoviesGenre(int id);
    }

    /**
     * ViewModel MoviesGenre
     */

    interface ViewModel {
        void setPresenter(MoviesGenrePresenter presenter);

        void onGetMoviesGenreSuccess(List<Movie> movies);

        void onGetMoviesGnereFailure(String message);
    }
}
