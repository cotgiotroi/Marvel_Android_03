package com.framgia.moviedb.screen.home;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.FragmentManager;

import com.framgia.moviedb.BR;

/**
 * Created by ducviet on 20/09/2017.
 */

public class HomeViewModel extends BaseObservable implements HomeContract.ViewModel {
    private HomeContract.Presenter mPresenter;
    private Context mContext;
    private HomeViewPager mHomeViewPager;

    public HomeViewModel(Context context, FragmentManager manager) {
        mContext = context;
        mHomeViewPager = new HomeViewPager(mContext, manager);
    }

    @Bindable
    public HomeViewPager getHomeViewPager() {
        return mHomeViewPager;
    }

    public void setHomeViewPager(HomeViewPager homeViewPager) {
        mHomeViewPager = homeViewPager;
        notifyPropertyChanged(BR.homeViewPager);
    }

    public void setPresenter(HomPresenter presenter) {
        mPresenter = presenter;
    }
}
