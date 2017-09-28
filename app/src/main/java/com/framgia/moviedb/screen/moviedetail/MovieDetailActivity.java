package com.framgia.moviedb.screen.moviedetail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.utils.Constant;

/**
 * MovieDetail
 */
public class MovieDetailActivity extends AppCompatActivity {
    public static Intent getInstance(Context context, long id) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(Constant.EXTRA_ID_MOVIE, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }
}
