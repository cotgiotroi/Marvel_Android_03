package com.framgia.moviedb.screen.activities.network;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.screen.activities.main.MainActivity;

/**
 * Created by ducviet on 17/09/2017.
 */

public class CheckNetworkViewModel extends BaseObservable
        implements NetworkContract.NetworkViewModel {
    private Boolean check;
    private CheckNetworkPresenter mPresenter;
    private Context mContext;

    public CheckNetworkViewModel(Context context) {
        mContext = context;
    }

    public void setPresenter(CheckNetworkPresenter presenter) {
        mPresenter = presenter;
        mPresenter.onCheckNetwork();
    }

    @Bindable
    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
        notifyPropertyChanged(BR.check);
    }

    @Override
    public void onSuccess() {
        check = false;
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void onError() {
        Toast.makeText(mContext, "Please Check Network ", Toast.LENGTH_SHORT).show();
    }
}
