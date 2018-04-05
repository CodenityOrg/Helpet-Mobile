package com.kincodi.helpet.helpetmobile;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.kincodi.helpet.helpetmobile.domain.executor.impl.ThreadExecutor;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.UpdateTokenFireBasePresenterImpl;
import com.kincodi.helpet.helpetmobile.threading.MainThreadImpl;


public class MyAndroidFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String TAG = "MyAndroidFCMIIDService";

    @Override
    public void onTokenRefresh() {
        //Get hold of the registration token
        //Log the token
        updateTokenFirebase();

    }

    public void updateTokenFirebase(){
        UpdateTokenFireBasePresenterImpl presenter = new UpdateTokenFireBasePresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance());
        presenter.updateTokenFireBase();
    }

    private void sendRegistrationToServer(String token) {
        //Implement this method if you want to store the token on your server
    }
}
