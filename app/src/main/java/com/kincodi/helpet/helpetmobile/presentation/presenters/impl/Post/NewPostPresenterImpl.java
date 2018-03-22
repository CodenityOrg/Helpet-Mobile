package com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.NewPostInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.impl.Post.NewPostInteractorImpl;
import com.kincodi.helpet.helpetmobile.domain.repository.PostRepository;
import com.kincodi.helpet.helpetmobile.presentation.presenters.NewPostPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.base.AbstractPresenter;

/**
 * Created by Julio on 19/03/2018.
 */

public class NewPostPresenterImpl extends AbstractPresenter implements NewPostPresenter,NewPostInteractor.Callback{
    private NewPostPresenter.View mView;
    private PostRepository mPostRepository;
    public NewPostPresenterImpl(Executor executor, MainThread mainThread,
                                NewPostPresenter.View view,
                                PostRepository postRepository) {
        super(executor, mainThread);
        mView = view;
        mPostRepository = postRepository;
    }
    @Override public void onCreated() {
        mView.onCreated();
    }
    @Override public void onCreateFailed(String message) {
        mView.onFailed(message);
    }
    @Override public void createPost(String name, String kind,String species,
                                     String race, String description,String location,
                                     String person_contact,String phone, String images) {
        NewPostInteractor newPostInteractor = new NewPostInteractorImpl(
                mExecutor,mMainThread,this,mPostRepository,
                name,kind,species,race,description,location,person_contact,phone,images);
        newPostInteractor.execute();
    }
}
