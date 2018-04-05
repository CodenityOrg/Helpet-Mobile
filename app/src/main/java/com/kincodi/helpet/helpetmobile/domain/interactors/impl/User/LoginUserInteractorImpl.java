package com.kincodi.helpet.helpetmobile.domain.interactors.impl.User;

import android.util.Log;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.LoginUserInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.base.AbstractInteractor;
import com.kincodi.helpet.helpetmobile.domain.model.User;
import com.kincodi.helpet.helpetmobile.domain.repository.UserRepository;
import com.kincodi.helpet.helpetmobile.storage.sharedprederences.ConfigSharedPreferences;
import com.kincodi.helpet.helpetmobile.storage.sharedprederences.UserSharedPreferences;

import retrofit2.Response;


/**
 * Created by Julio on 20/02/2018.
 */

public class LoginUserInteractorImpl extends AbstractInteractor
        implements LoginUserInteractor {
    private UserRepository mUserRepository;
    private String mEmail;
    private String mPassword;
    private MainThread mMainThread;
    private LoginUserInteractor.Callback mCallback;
    public LoginUserInteractorImpl(Executor threadExecutor,
                                   MainThread mainThread,
                                   Callback callback,
                                   UserRepository userRepository,
                                   String email, String password) {
        super(threadExecutor, mainThread);
        mUserRepository = userRepository;
        mEmail = email;
        mPassword = password;
        mMainThread = mainThread;
        mCallback = callback;
    }
    @Override public void run() {
        User user = new User();
        user.setEmail(mEmail);
        user.setPassword(mPassword);
        Response result = mUserRepository.login(user);
        if(result!=null){
            if(result.isSuccessful()){
                user = (User)result.body();
                UserSharedPreferences.saveUser(user);
                ConfigSharedPreferences.saveConfig(user.getToken());

                loginSuccess();
            }else{
                String message = getMessage(result.code());
                notifyError(message);
            }
        }else {
            String message = getMessage(0);
            notifyError(message);
        }
    }
    private void notifyError(final String message){
        mMainThread.post(new Runnable() {
            @Override public void run() {
                mCallback.onLoginFailed(message);
            }
        });
    }
    private void loginSuccess(){
        mMainThread.post(new Runnable() {
            @Override public void run() {
                mCallback.onLogged();
            }
        });
    }
    private String getMessage(int code){
        String message;
        switch (code){
            case 401:
                message = "Usuario o contraseña incorrectos";
                break;
            case 400:
                message = "Intentar nuevamente";
                break;
            default:
                message = "Error en el incio de session";
        }
        return message;
    }
}
