package com.framgia.moviedb.screen.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.framgia.moviedb.R;
import com.framgia.moviedb.screen.movie.MovieFragment;
import com.framgia.moviedb.screen.genres.GenresFragment;

import static com.framgia.moviedb.utils.Constant.GENRES;
import static com.framgia.moviedb.utils.Constant.NOW_PLAYING;
import static com.framgia.moviedb.utils.Constant.POPULAR;
import static com.framgia.moviedb.utils.Constant.TOP_RATE;
import static com.framgia.moviedb.utils.Constant.UP_COMING;

/**
 * Created by ducviet on 20/09/2017.
 */

public class HomeViewPager extends FragmentPagerAdapter {

    public static final int[] TABS =
            new int[] { POPULAR, UP_COMING, TOP_RATE, NOW_PLAYING, GENRES };
    private Context mContext;

    public HomeViewPager(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (TABS[position]) {
            case POPULAR:
                return new MovieFragment().getInstance(POPULAR);
            case UP_COMING:
                return new MovieFragment().getInstance(UP_COMING);
            case TOP_RATE:
                return new MovieFragment().getInstance(TOP_RATE);
            case NOW_PLAYING:
                return new MovieFragment().getInstance(NOW_PLAYING);
            case GENRES:
                return new GenresFragment();
            default:
                return new MovieFragment().getInstance(POPULAR);
        }
    }

    @Override
    public int getCount() {
        return TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case POPULAR:
                return mContext.getResources().getString(R.string.title_popular);
            case UP_COMING:
                return mContext.getResources().getString(R.string.title_coming);
            case TOP_RATE:
                return mContext.getResources().getString(R.string.title_top);
            case NOW_PLAYING:
                return mContext.getResources().getString(R.string.title_playing);
            case GENRES:
                return mContext.getResources().getString(R.string.title_genres);
            default:
                return null;
        }
    }
}
