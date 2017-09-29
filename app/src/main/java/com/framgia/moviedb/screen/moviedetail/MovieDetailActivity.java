package com.framgia.moviedb.screen.moviedetail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.source.remote.MovieDataResource;
import com.framgia.moviedb.data.source.remote.MovieDataRespository;
import com.framgia.moviedb.data.source.remote.api.MovieRemoteDataResource;
import com.framgia.moviedb.data.source.remote.api.service.MovieServiceClient;
import com.framgia.moviedb.databinding.ActivityMovieDetailBinding;

import static com.framgia.moviedb.utils.Constant.EXTRA_ID_MOVIE;

/**
 * MovieDetail
 */
public class MovieDetailActivity extends AppCompatActivity {
    public static Intent getInstance(Context context, long id) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_ID_MOVIE, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMovieDetailBinding binding =
                DataBindingUtil.setContentView(MovieDetailActivity.this,
                        R.layout.activity_movie_detail);
        Intent i = getIntent();
        int id = (int) i.getExtras().getLong(EXTRA_ID_MOVIE);
        MovieDataResource movieDataRepository = new MovieDataRespository(
                new MovieRemoteDataResource(MovieServiceClient.getInstance()));
        MovieDetailContract.ViewModel viewModel =
                new MovieDetailViewModel(MovieDetailActivity.this, id);
        MovieDetailContract.Presenter presenter =
                new MovieDetailPresenter(viewModel, (MovieDataRespository) movieDataRepository);
        viewModel.setPresenter(presenter);
        binding.setViewModel((MovieDetailViewModel) viewModel);
    }
}
