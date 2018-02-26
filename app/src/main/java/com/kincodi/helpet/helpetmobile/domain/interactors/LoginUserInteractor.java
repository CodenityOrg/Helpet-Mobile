package com.kincodi.helpet.helpetmobile.domain.interactors;

import com.kincodi.helpet.helpetmobile.domain.interactors.base.Interactor;

/**
 * Created by Julio on 24/02/2018.
 */

public interface LoginUserInteractor extends Interactor {

    interface Callback{
        void onLogged();
        void onLoginFailed(String message);
    }
}
