package com.framgia.moviedb.screen.genres;

import com.framgia.moviedb.data.model.Genre;
import java.util.List;

/**
 * Created by ducviet on 27/09/2017.
 */

public interface GenresContract {
    /**
     * Presenter Genres
     */
    interface Presenter {
        void getGenres();
    }

    /**
     * ViewModel Genres
     */
    interface ViewModel {
        void setPresenter(GenresPresenter presenter);

        void onGetGenresSuccess(List<Genre> genres);

        void onGetGenresFailure(String message);
    }
}
