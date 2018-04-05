package com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.GetListPostInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.impl.Post.GetListPostInteractorImpl;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.presentation.presenters.GetListPostPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.base.AbstractPresenter;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;

import java.util.List;

/**
 * Created by Julio on 2/04/2018.
 */

public class GetListPostPresenterImpl extends AbstractPresenter implements GetListPostPresenter,GetListPostInteractor.Callback {
    PostRepositoryImpl mPostRepository;
    GetListPostPresenter.View mView;
    public GetListPostPresenterImpl(Executor executor,
                                    MainThread mainThread,
                                    PostRepositoryImpl postRepository,
                                    GetListPostPresenter.View view) {
        super(executor, mainThread);
        mPostRepository = postRepository;
        mView = view;
    }
    @Override public void onGotPosts(List<Post> posts) {
        mView.onSuccessGotPost(posts);
    }
    @Override public void onFailedGetPosts(String message) {
        mView.onFailedGotPost(message);
    }
    @Override public void getPosts(int type) {
        GetListPostInteractorImpl interactor = new GetListPostInteractorImpl(mExecutor,mMainThread,mPostRepository,this, type);
        interactor.execute();
    }


}
