package com.kincodi.helpet.helpetmobile.domain.interactors;

import com.kincodi.helpet.helpetmobile.domain.model.Post;

public interface GetInfoInteractor {
    interface Callback{
        void gotInfo(Post post);
        void onGetFailed(String message);
    }
}
