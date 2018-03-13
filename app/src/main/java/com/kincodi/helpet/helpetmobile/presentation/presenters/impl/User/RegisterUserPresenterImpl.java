package com.kincodi.helpet.helpetmobile.presentation.presenters.impl.User;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.RegisterUserInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.impl.User.RegisterUserInteractorImpl;
import com.kincodi.helpet.helpetmobile.domain.repository.UserRepository;
import com.kincodi.helpet.helpetmobile.presentation.presenters.RegisterUserPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.base.AbstractPresenter;

/**
 * Created by Julio on 13/03/2018.
 */

public class RegisterUserPresenterImpl extends AbstractPresenter implements RegisterUserPresenter,RegisterUserInteractor.Callback{

    private RegisterUserPresenter.View mView;
    private UserRepository mUserRepository;

    public RegisterUserPresenterImpl(Executor executor, MainThread mainThread,
                                     RegisterUserPresenter.View view,
                                     UserRepository userRepository) {
        super(executor, mainThread);
        mView = view;
        mUserRepository = userRepository;
    }

    @Override
    public void onRegistered() {
        mView.onRegistered();
    }

    @Override
    public void onRegisterFailed(String message) {
        mView.onFailed(message);
    }

    @Override
    public void register(String name, String lastname, String phone, String email,
                         String password) {
        RegisterUserInteractor registerUserInteractor =
                new RegisterUserInteractorImpl(
                        mExecutor,
                        mMainThread,
                        this,
                        mUserRepository,name,lastname,phone,email,password);
    }
}
