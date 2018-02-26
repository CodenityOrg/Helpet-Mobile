package com.kincodi.helpet.helpetmobile.presentation.presenters;

import com.kincodi.helpet.helpetmobile.presentation.ui.BaseView;

/**
 * Created by Julio on 24/02/2018.
 */

public interface LoginUserPresenter {

    interface View extends BaseView {
        void onLogged();
        void onFailed(String message);
        void loginNormal();
    }
    void login(String email,String password);
}
