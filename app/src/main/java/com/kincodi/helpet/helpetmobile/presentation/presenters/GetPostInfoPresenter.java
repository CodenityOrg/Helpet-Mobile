package com.kincodi.helpet.helpetmobile.presentation.presenters;

import com.kincodi.helpet.helpetmobile.presentation.ui.BaseView;

public interface GetPostInfoPresenter {

    interface View extends BaseView {
        void gotInfo();
        void onFailed(String message);
    }
    void getInfo(String id);

}
