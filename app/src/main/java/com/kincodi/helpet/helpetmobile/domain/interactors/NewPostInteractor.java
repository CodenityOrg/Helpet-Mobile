package com.kincodi.helpet.helpetmobile.domain.interactors;

import com.kincodi.helpet.helpetmobile.domain.interactors.base.Interactor;

/**
 * Created by Julio on 19/03/2018.
 */

public interface NewPostInteractor extends Interactor{
    interface Callback{
        void onCreated();
        void onCreateFailed(String message);
    }
}
