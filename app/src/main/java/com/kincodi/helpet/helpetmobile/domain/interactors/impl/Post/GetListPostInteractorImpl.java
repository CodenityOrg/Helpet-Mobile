package com.kincodi.helpet.helpetmobile.domain.interactors.impl.Post;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.GetListPostInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.base.AbstractInteractor;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.presentation.presenters.base.AbstractPresenter;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;

import java.util.List;

import retrofit2.Response;

/**
 * Created by Julio on 2/04/2018.
 */

public class GetListPostInteractorImpl extends AbstractInteractor implements GetListPostInteractor {

    PostRepositoryImpl mPostRepositoryImpl;
    GetListPostInteractor.Callback mCallback;
    MainThread mMainThread;
    String mType;

    public GetListPostInteractorImpl(Executor threadExecutor,
                                     MainThread mainThread,
                                     PostRepositoryImpl postRepository,
                                     GetListPostInteractor.Callback callback,
                                     String type) {
        super(threadExecutor, mainThread);
        mType = type;


    }
    void onSuccess(final List<Post> posts){
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onGotPosts(posts);
            }
        });
    }

    void onFailed(final String message){
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFailedGetPosts(message);
            }
        });
    }
    @Override
    public void run() {
        Response response = mPostRepositoryImpl.getPosts(mType);
        if (response!=null){
            if (response.isSuccessful()){
                List<Post> posts = (List<Post>) response.body();
                onSuccess(posts);

            }else{
                onFailed("Intente nuevamente");
            }
        }else{
            onFailed("Intente nuevamente");
        }
    }
}
