package com.framgia.moviedb.screen.network;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.databinding.ActivityNetworkBinding;
/*
* hoducviet network
*/

public class NetworkActivity extends AppCompatActivity {
    private CheckNetworkViewModel mViewModel;
    private CheckNetworkPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNetworkBinding binding =
                DataBindingUtil.setContentView(NetworkActivity.this,
                        R.layout.activity_check_network);
        mViewModel = new CheckNetworkViewModel(NetworkActivity.this);
        mPresenter = new CheckNetworkPresenter(NetworkActivity.this, mViewModel);
        mViewModel.setPresenter(mPresenter);
        binding.setNetworkviewmodel(mViewModel);
    }
}
