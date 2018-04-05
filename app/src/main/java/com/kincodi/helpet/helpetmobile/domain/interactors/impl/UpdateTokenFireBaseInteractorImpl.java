package com.kincodi.helpet.helpetmobile.domain.interactors.impl;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.UpdateTokenFireBaseInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.base.AbstractInteractor;
import com.kincodi.helpet.helpetmobile.storage.UserRepositoryImpl;

import retrofit2.Response;

/**
 * Created by Julio on 4/04/2018.
 */

public class UpdateTokenFireBaseInteractorImpl extends AbstractInteractor implements UpdateTokenFireBaseInteractor {
    UserRepositoryImpl mUserRepositoryImpl;
    MainThread mMainThread;
    String mFirebaseId, mOldFirebaseId;

    public UpdateTokenFireBaseInteractorImpl(Executor threadExecutor,
                                             MainThread mainThread,
                                             UserRepositoryImpl userRepository,
                                             String firebaseId) {
        super(threadExecutor, mainThread);
        mUserRepositoryImpl = userRepository;
        mMainThread = mainThread;
        mFirebaseId = firebaseId;
    }

    @Override
    public void run() {
        Response response = mUserRepositoryImpl.updateFireBaseId(mFirebaseId,mOldFirebaseId);
        if(response!=null){
            if(response.isSuccessful()){
            }
        }
    }
}
