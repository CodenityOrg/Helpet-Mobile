package com.kincodi.helpet.helpetmobile.domain.interactors.base;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;

public abstract class AbstractInteractor implements Interactor{

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    protected volatile  boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    public AbstractInteractor(Executor threadExecutor, MainThread mainThread){
        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
    }
    public abstract void run();

    public boolean isRunning(){
        return mIsRunning;
    }
    public void cancel(){
        mIsCanceled = true;
        mIsRunning = false;
    }
    public void execute(){
        this.mIsRunning = true;
        mThreadExecutor.executor(this);
    }
    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
    }
}
