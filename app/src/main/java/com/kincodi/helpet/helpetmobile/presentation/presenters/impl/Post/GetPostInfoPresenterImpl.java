package com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.presentation.presenters.GetListPostPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.GetPostInfoPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.base.AbstractPresenter;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;

public class GetPostInfoPresenterImpl extends AbstractPresenter implements GetPostInfoPresenter {
    PostRepositoryImpl mPostRepository;
    GetPostInfoPresenter.View mView;
    public GetPostInfoPresenterImpl(Executor executor,
                                    MainThread mainThread,
                                    PostRepositoryImpl postRepository,
                                    GetPostInfoPresenter.View view) {
        super(executor, mainThread);
        mPostRepository = postRepository;
        mView = view;
    }

    @Override
    public void getInfo(String id) {

    }
}
