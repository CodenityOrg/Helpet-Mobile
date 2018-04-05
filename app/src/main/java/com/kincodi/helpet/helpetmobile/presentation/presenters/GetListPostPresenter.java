package com.kincodi.helpet.helpetmobile.presentation.presenters;

import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.presentation.ui.BaseView;

import java.util.List;

/**
 * Created by Julio on 2/04/2018.
 */

public interface GetListPostPresenter {
    interface  View extends BaseView{
        void onSuccessGotPost(List<Post> posts);
        void onFailedGotPost(String message);

    }
    void getPosts(int type);
}
