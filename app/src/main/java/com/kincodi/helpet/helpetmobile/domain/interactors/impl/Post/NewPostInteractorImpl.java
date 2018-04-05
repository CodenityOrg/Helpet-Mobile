package com.kincodi.helpet.helpetmobile.domain.interactors.impl.Post;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.NewPostInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.base.AbstractInteractor;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.repository.PostRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Response;

/**
 * Created by Julio on 19/03/2018.
 */

public class NewPostInteractorImpl extends AbstractInteractor
        implements NewPostInteractor{

    private PostRepository mPostRepository;
    private String mName;
    private String mKind;
    private String mRace;
    private String mDescription;
    private Double[] mPosition;
    private String mPhone;
    private Date mDate;
    private String mAge;
    private ArrayList<String> mFile;
    private MainThread mMainThread;
    private NewPostInteractor.Callback mCallback;
    public NewPostInteractorImpl(Executor threadExecutor,
                                 MainThread mainThread,
                                 Callback callback,
                                 PostRepository postRepository,
                                 String name,
                                 String description,
                                 String race,
                                 String age,
                                 String kind,
                                 Date date,
                                 Double[] position,
                                 String phone,
                                 ArrayList<String> file
    ) {
        super(threadExecutor, mainThread);
        mPostRepository = postRepository;
        mMainThread = mainThread;
        mCallback = callback;
        mName = name;
        mKind = kind;
        mRace = race;
        mDate = date;
        mAge  = age;
        mDescription = description;
        mPosition = position;
        mPhone = phone;
        mFile = file;
    }
    @Override
    public void run() {
        Post post = new Post();
        post.setName(mName);
        post.setDescription(mDescription);
        post.setKind(mKind);
        post.setPosition(mPosition);
        post.setPhone(mPhone);
        post.setRace(mRace);
        post.setDate(mDate);
        post.setAge(mAge);
        Response result = mPostRepository.create(mFile,post);
        if (result!=null){
            if (result.isSuccessful()){
                createSuccess();
            }else{
                String message = getMessage(result.code());
                notifyError(message);
            }
        }else{
            String message = getMessage(0);
            notifyError(message);
        }
    }
    private String getMessage(int code){
        String message;
        switch (code){
            case 401:
                message = "datos no validos";
                break;
            case 400:
                message = "Intentar nuevamente";
                break;
            default:
                message = "Error en el creacion de publicacion";
        }
        return message;
    }
    private void notifyError(final String message){
        mMainThread.post(new Runnable() {
            @Override public void run() {
                mCallback.onCreateFailed(message);
            }
        });
    }
    private void createSuccess(){
        mMainThread.post(new Runnable() {
            @Override public void run() {
                mCallback.onCreated();
            }
        });
    }
}
