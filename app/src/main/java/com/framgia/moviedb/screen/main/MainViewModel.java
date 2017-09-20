package com.framgia.moviedb.screen.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.FragmentManager;
import com.framgia.moviedb.BR;

/**
 * Created by ducviet on 20/09/2017.
 */

public class MainViewModel extends BaseObservable implements MainContract.ViewModel {
    private MainContract.Presenter mPresenter;
    private Context mContext;
    private MainSectionAdapter mAdapter;

    public MainViewModel(Context context, FragmentManager fragmentManager) {
        mContext = context;
        setAdapter(new MainSectionAdapter(mContext, fragmentManager));
    }

    @Bindable
    public MainSectionAdapter getAdapterPager() {
        return mAdapter;
    }

    public void setAdapter(MainSectionAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapterPager);
    }

    public void setPresenter(MainPresenter presenter) {
        mPresenter = presenter;
    }
}
