package com.framgia.moviedb.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.framgia.moviedb.utils.Constant;
import com.framgia.moviedb.utils.LayoutManager;
import com.squareup.picasso.Picasso;

/**
 * Created by ducviet on 20/09/2017.
 */

public class BindingUtils {
    @BindingAdapter({ "bind:recyclerAdapter" })
    public static void setRecyclerAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({ "bind:adapter" })
    public static void bindViewPagerAdapter(ViewPager view, FragmentPagerAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter({ "bind:pager" })
    public static void bindViewPagerTabs(TabLayout view, ViewPager pagerView) {
        view.setupWithViewPager(pagerView, true);
    }

    @BindingAdapter({ "bind:imageMovie" })
    public static void loadImageBackground(ImageView imageView, String uri) {
        Picasso.with(imageView.getContext()).load(Constant.MOVIE_IMAGE_URL + uri).into(imageView);
    }

    @BindingAdapter("bind:layoutManagerRecycler")
    public static void setLayoutManager(RecyclerView recyclerView,
            LayoutManager.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }
}
