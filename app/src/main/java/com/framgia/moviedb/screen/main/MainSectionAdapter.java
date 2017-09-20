package com.framgia.moviedb.screen.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.framgia.moviedb.R;
import com.framgia.moviedb.screen.favorite.FavoriteFragment;
import com.framgia.moviedb.screen.home.HomeFragment;

import static com.framgia.moviedb.utils.Constant.FAVORITE;
import static com.framgia.moviedb.utils.Constant.HOME;

/**
 * Created by ducviet on 20/09/2017.
 */

public class MainSectionAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public static final int[] TABS = new int[] { HOME, FAVORITE };

    public MainSectionAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (TABS[position]) {
            case HOME:
                return new HomeFragment();
            case FAVORITE:
                return new FavoriteFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case HOME:
                return mContext.getResources().getString(R.string.title_home);
            case FAVORITE:
                return mContext.getResources().getString(R.string.title_favorite);
            default:
                return null;
        }
    }
}
