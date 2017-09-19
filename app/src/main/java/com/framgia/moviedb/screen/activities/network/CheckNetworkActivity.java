package com.framgia.moviedb.screen.activities.network;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.databinding.ActivityCheckBinding;
import com.framgia.moviedb.utils.CheckNetwork;

public class CheckNetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCheckBinding binding =
                DataBindingUtil.setContentView(CheckNetworkActivity.this, R.layout.activity_check);
        CheckNetworkViewModel viewModel = new CheckNetworkViewModel(CheckNetworkActivity.this);
        CheckNetworkPresenter mPresenter =
                new CheckNetworkPresenter(CheckNetworkActivity.this, viewModel);
        viewModel.setPresenter(mPresenter);
        binding.setNetworkviewmodel(viewModel);
    }
}
