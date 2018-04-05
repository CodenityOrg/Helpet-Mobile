package com.kincodi.helpet.helpetmobile.domain.interactors.impl.Post;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.GetInfoInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.GetListPostInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.base.AbstractInteractor;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;

import java.util.List;

import retrofit2.Response;

public class GetInfoInteractorImpl extends AbstractInteractor implements GetInfoInteractor {

    PostRepositoryImpl mPostRepositoryImpl;
    MainThread mMainThread;
    GetInfoInteractor.Callback mCallback;
    String mPostId;

    public GetInfoInteractorImpl(Executor threadExecutor,
                                     MainThread mainThread,
                                     PostRepositoryImpl postRepository,
                                     String postId,
                                     GetInfoInteractor.Callback callback) {
        super(threadExecutor, mainThread);
        mPostRepositoryImpl = postRepository;
        mCallback = callback;
        mPostId = postId;
    }



    void onSuccess(final Post post){
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.gotInfo(post);
            }
        });
    }

    void onFailed(final String message){
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onGetFailed(message);
            }
        });
    }

    @Override
    public void run() {
        Response response = mPostRepositoryImpl.getPost(mPostId);
        if (response!=null){
            if (response.isSuccessful()){
                Post post = (Post) response.body();
                onSuccess(post);

            }else{
                onFailed("Intente nuevamente");
            }
        }else{
            onFailed("Intente nuevamente");
        }
    }
}
