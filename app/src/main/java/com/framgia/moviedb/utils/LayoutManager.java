package com.framgia.moviedb.utils;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ducviet on 26/09/2017.
 */

public final class LayoutManager {
    private LayoutManager() {
    }

    public static LayoutManagerFactory grid(final int spanCount) {
        return new LayoutManagerFactory() {
            @Override
            public RecyclerView.LayoutManager create(RecyclerView recyclerView) {
                return new GridLayoutManager(recyclerView.getContext(), spanCount);
            }
        };
    }
    /**
     * LayoutManager Recycler
     */
    public interface LayoutManagerFactory {
        RecyclerView.LayoutManager create(RecyclerView recyclerView);
    }
}
