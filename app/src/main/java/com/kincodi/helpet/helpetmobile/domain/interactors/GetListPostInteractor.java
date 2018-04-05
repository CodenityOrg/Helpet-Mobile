package com.kincodi.helpet.helpetmobile.domain.interactors;

import com.kincodi.helpet.helpetmobile.domain.model.Post;

import java.util.List;

/**
 * Created by Julio on 2/04/2018.
 */

public interface GetListPostInteractor{

    interface  Callback{
        void onGotPosts(List<Post> posts);
        void onFailedGetPosts(String message);
    }
}
