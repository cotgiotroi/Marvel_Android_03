package com.framgia.moviedb.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by ducviet on 17/09/2017.
 */

public class CheckNetwork {
    private Context mContext;

    public CheckNetwork(Context context) {
        mContext = context;
    }

    public boolean checkNetwork() {

        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }
}
