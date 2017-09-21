package com.framgia.moviedb.screen.movie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.moviedb.R;

/**
 * A simple {@link MovieFragment} subclass.
 */
public class MovieFragment extends Fragment {

    public MovieFragment getInstance() {
        return new MovieFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }
}
