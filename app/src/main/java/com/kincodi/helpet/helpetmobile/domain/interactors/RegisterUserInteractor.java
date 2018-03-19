package com.kincodi.helpet.helpetmobile.domain.interactors;

import com.kincodi.helpet.helpetmobile.domain.interactors.base.Interactor;

/**
 * Created by Julio on 13/03/2018.
 */

public interface RegisterUserInteractor extends Interactor{
    interface Callback{
        void onRegistered();
        void onRegisterFailed(String message);
    }
}
