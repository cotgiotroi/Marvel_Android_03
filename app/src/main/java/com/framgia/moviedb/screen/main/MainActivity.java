package com.framgia.moviedb.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.databinding.ActivityMainBinding;

/**
 * hoducviet main viewpager
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        MainContract.ViewModel mViewModel =
                new MainViewModel(MainActivity.this, getSupportFragmentManager());
        MainContract.Presenter mPresenter = new MainPresenter((MainViewModel) mViewModel);
        ((MainViewModel) mViewModel).setPresenter((MainPresenter) mPresenter);
        binding.setViewModel((MainViewModel) mViewModel);
    }
}
