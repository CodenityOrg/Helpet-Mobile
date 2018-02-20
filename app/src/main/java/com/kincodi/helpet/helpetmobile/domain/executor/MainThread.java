package com.kincodi.helpet.helpetmobile.domain.executor;

/**
 * Created by Julio on 20/02/2018.
 */

public interface MainThread {
    void post(final Runnable runnable);
}
