package com.kincodi.helpet.helpetmobile.domain.interactors.impl.User;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.RegisterUserInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.base.AbstractInteractor;
import com.kincodi.helpet.helpetmobile.domain.model.User;
import com.kincodi.helpet.helpetmobile.domain.repository.UserRepository;
import com.kincodi.helpet.helpetmobile.storage.sharedprederences.UserSharedPreferences;

import retrofit2.Response;

public class RegisterUserInteractorImpl extends AbstractInteractor implements RegisterUserInteractor {
    private UserRepository mUserRepository;
    private String mName;
    private String mLastName;
    private String mPhone;
    private String mEmail;
    private String mPassword;
    private MainThread mMainThread;
    private RegisterUserInteractor.Callback mCallback;

    public RegisterUserInteractorImpl(Executor threadExecutor,
                                      MainThread mainThread,
                                      Callback callback,
                                      UserRepository userRepository,
                                      String name,String lastname, String phone,
                                      String email, String password) {
        super(threadExecutor, mainThread);
        mUserRepository = userRepository;
        mName = name;
        mLastName = lastname;
        mPhone = phone;
        mEmail = email;
        mPassword = password;
        mMainThread = mainThread;
        mCallback = callback;
    }

    @Override
    public void run() {
        User user  = new User();
        user.setFirstName(mName);
        user.setLastName(mLastName);
        user.setEmail(mEmail);
        user.setPhone(mPhone);
        user.setPassword(mPassword);
        Response result = mUserRepository.register(user);
        if(result!=null){
            if(result.isSuccessful()   ){
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
                mCallback.onRegisterFailed(message);
            }
        });
    }
    private void loginSuccess(){
        mMainThread.post(new Runnable() {
            @Override public void run() {
                mCallback.onRegistered();
            }
        });
    }
    private String getMessage(int code){
        String message;
        switch (code){
            case 401:
                message = "Datos  incorrectos";
                break;
            case 400:
                message = "Intentar nuevamente";
                break;
            default:
                message = "Error en el registro";
        }
        return message;
    }
}
