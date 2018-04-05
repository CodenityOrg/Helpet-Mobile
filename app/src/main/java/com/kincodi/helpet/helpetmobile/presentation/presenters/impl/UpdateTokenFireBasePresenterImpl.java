package com.kincodi.helpet.helpetmobile.presentation.presenters.impl;

import com.google.firebase.iid.FirebaseInstanceId;
import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.impl.UpdateTokenFireBaseInteractorImpl;
import com.kincodi.helpet.helpetmobile.presentation.presenters.UpdateTokenFireBasePresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.base.AbstractPresenter;
import com.kincodi.helpet.helpetmobile.storage.UserRepositoryImpl;
import com.kincodi.helpet.helpetmobile.storage.sharedprederences.UserSharedPreferences;

/**
 * Created by Julio on 4/04/2018.
 */

public class UpdateTokenFireBasePresenterImpl extends AbstractPresenter implements UpdateTokenFireBasePresenter {
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    public UpdateTokenFireBasePresenterImpl(Executor executor, MainThread mainThread){
        super(executor,mainThread);
    }
    @Override public void updateTokenFireBase() {
        String token = FirebaseInstanceId.getInstance().getToken();
        String oldToken = UserSharedPreferences.getFireBaseId();
        UpdateTokenFireBaseInteractorImpl interactor = new UpdateTokenFireBaseInteractorImpl(mExecutor,mMainThread,userRepository,token,oldToken);
        interactor.execute();
        UserSharedPreferences.setFireBaseId(token);

    }
}
