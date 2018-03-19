package com.kincodi.helpet.helpetmobile.presentation.presenters;

import com.kincodi.helpet.helpetmobile.presentation.ui.BaseView;

/**
 * Created by Julio on 13/03/2018.
 */

public interface RegisterUserPresenter {
    interface View extends BaseView {
        void onRegistered();
        void onFailed(String message);
        void registerNormal();
    }
    void register(String name,String lastname,String phone,String email,String password);
}
