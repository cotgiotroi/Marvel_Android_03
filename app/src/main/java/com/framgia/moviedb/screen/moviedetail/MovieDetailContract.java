package com.framgia.moviedb.screen.moviedetail;

import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.MovieDetail;
import java.util.List;

/**
 * Created by ducviet on 28/09/2017.
 */

public interface MovieDetailContract {
    /**
     * Presenter Movie Detail
     */
    interface Presenter {
        void getMovieDetail(int id);
    }

    /**
     * ViewModel Movie Detail
     */
    interface ViewModel {
        void setPresenter(MovieDetailContract.Presenter presenter);
        void onGetMovieDetailSuccess(MovieDetail movie);
        void onGetMoviesSimilarSuccess(List<Movie> movies);
        void onGetMovieDetailFailure(String message);
    }
}
