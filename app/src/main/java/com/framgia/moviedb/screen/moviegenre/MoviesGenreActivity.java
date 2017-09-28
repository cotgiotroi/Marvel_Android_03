package com.framgia.moviedb.screen.moviegenre;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.source.remote.MovieDataResource;
import com.framgia.moviedb.data.source.remote.MovieDataRespository;
import com.framgia.moviedb.data.source.remote.api.MovieRemoteDataResource;
import com.framgia.moviedb.data.source.remote.api.service.MovieServiceClient;
import com.framgia.moviedb.databinding.ActivityMoviesGenreBinding;

import static com.framgia.moviedb.utils.Constant.EXTRA_GENRE;

/**
 * Movies Genre
 */
public class MoviesGenreActivity extends AppCompatActivity {

    public static Intent getInstance(Context context, Genre genre) {
        Intent intent = new Intent(context, MoviesGenreActivity.class);
        intent.putExtra(EXTRA_GENRE, genre);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMoviesGenreBinding binding =
                DataBindingUtil.setContentView(MoviesGenreActivity.this,
                        R.layout.activity_movies_genre);
        Intent i = getIntent();
        Genre genre = i.getExtras().getParcelable(EXTRA_GENRE);
        MovieDataResource movieDataRespository = new MovieDataRespository(
                new MovieRemoteDataResource(MovieServiceClient.getInstance()));
        MoviesGenreContract.ViewModel viewModel =
                new MoviesGenreViewModel(MoviesGenreActivity.this, genre.getName(),
                        (int) genre.getId());
        MoviesGenreContract.Presenter presenter =
                new MoviesGenrePresenter((MovieDataRespository) movieDataRespository, viewModel);
        viewModel.setPresenter((MoviesGenrePresenter) presenter);
        binding.setViewModel((MoviesGenreViewModel) viewModel);
    }
}
