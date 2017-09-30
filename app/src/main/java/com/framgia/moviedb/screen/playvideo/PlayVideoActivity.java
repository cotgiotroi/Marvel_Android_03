package com.framgia.moviedb.screen.playvideo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.source.remote.VideoDataRepository;
import com.framgia.moviedb.data.source.remote.VideoDataResource;
import com.framgia.moviedb.data.source.remote.api.VideoRemoteDataResource;
import com.framgia.moviedb.data.source.remote.api.service.MovieServiceClient;
import com.framgia.moviedb.databinding.ActivityPlayVideoBinding;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import static com.framgia.moviedb.utils.Constant.EXTRA_ID_MOVIE;

public class PlayVideoActivity extends YouTubeBaseActivity {
    public static Intent getInstance(Context context, long id) {
        Intent intent = new Intent(context, PlayVideoActivity.class);
        intent.putExtra(EXTRA_ID_MOVIE, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlayVideoBinding binding = DataBindingUtil.setContentView(PlayVideoActivity.this,
                R.layout.activity_play_video);
        Intent i = getIntent();
        int id = (int) i.getExtras().getLong(EXTRA_ID_MOVIE);
        VideoDataResource videoRepository = new VideoDataRepository(
                new VideoRemoteDataResource(MovieServiceClient.getInstance()));
        PlayVideoContract.ViewModel viewModel = new PlayVieoViewModel(PlayVideoActivity.this, id);
        PlayVideoContract.Presenter presenter =
                new PlayVideoPresenter(viewModel, (VideoDataRepository) videoRepository);
        viewModel.setPresenter(presenter);
        binding.setViewModel((PlayVieoViewModel) viewModel);
    }

}
