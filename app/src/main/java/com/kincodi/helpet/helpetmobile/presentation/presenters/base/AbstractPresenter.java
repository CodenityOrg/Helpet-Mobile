package com.kincodi.helpet.helpetmobile.presentation.presenters.base;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;

/**
 * Created by Julio on 20/02/2018.
 */

public abstract class AbstractPresenter {
    protected Executor   mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(
            Executor executor,
            MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
