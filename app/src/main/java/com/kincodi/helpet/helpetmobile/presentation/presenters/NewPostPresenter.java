package com.kincodi.helpet.helpetmobile.presentation.presenters;

import com.kincodi.helpet.helpetmobile.presentation.ui.BaseView;

/**
 * Created by Julio on 19/03/2018.
 */

public interface NewPostPresenter {
    interface View extends BaseView {
        void onCreated();
        void onFailed(String message);
        void createNormal();
    }
    void createPost(String name,String kind,
            String species, String race,
            String description,String location,
            String person_contact,String phone,
            String images);
}
