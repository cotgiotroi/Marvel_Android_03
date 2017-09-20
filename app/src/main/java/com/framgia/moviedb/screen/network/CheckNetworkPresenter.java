package com.framgia.moviedb.screen.network;

import android.content.Context;
import android.os.Handler;
import com.framgia.moviedb.utils.CheckNetwork;

/**
 * Created by ducviet on 17/09/2017.
 */

public class CheckNetworkPresenter implements NetworkContract.NetworkPresenter {
    private Context mContext;
    private CheckNetworkViewModel mViewModel;

    public CheckNetworkPresenter(Context context, CheckNetworkViewModel viewModel) {
        mContext = context;
        mViewModel = viewModel;
    }

    @Override
    public void onCheckNetwork() {
        final Handler handler = new Handler();
        handler.postAtTime(new Runnable() {
            @Override
            public void run() {
                CheckNetwork checkNetwork = new CheckNetwork(mContext);
                if (checkNetwork.checkNetwork()) {
                    mViewModel.onSuccess();
                } else {
                    mViewModel.onError();
                    handler.postDelayed(this, 2000);
                }
            }
        }, 2000);
    }
}
