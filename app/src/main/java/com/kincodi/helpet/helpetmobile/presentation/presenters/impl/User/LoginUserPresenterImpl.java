package com.kincodi.helpet.helpetmobile.presentation.presenters.impl.User;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.LoginUserInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.impl.User.LoginUserInteractorImpl;
import com.kincodi.helpet.helpetmobile.domain.repository.UserRepository;
import com.kincodi.helpet.helpetmobile.presentation.presenters.LoginUserPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.base.AbstractPresenter;

/**
 * Created by Julio on 24/02/2018.
 */

public class LoginUserPresenterImpl extends AbstractPresenter implements LoginUserPresenter, LoginUserInteractor.Callback{

    private LoginUserPresenter.View mView;
    private UserRepository mUserRepository;
    public LoginUserPresenterImpl(Executor executor, MainThread mainThread,
                                  LoginUserPresenter.View view,
                                  UserRepository userRepository) {
        super(executor,mainThread);
        mView = view;
        mUserRepository = userRepository;
    }
    @Override public void login(String email, String password) {
        LoginUserInteractor loginUserInteractor = new LoginUserInteractorImpl(
                mExecutor, mMainThread, this,
                mUserRepository, email, password);
        loginUserInteractor.execute();
    }
    @Override public void onLogged() {
        mView.onLogged();
    }
    @Override public void onLoginFailed(String message) {
        mView.onFailed(message);
    }
}
