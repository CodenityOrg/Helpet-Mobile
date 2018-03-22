package com.kincodi.helpet.helpetmobile.domain.interactors.impl.Post;

import com.kincodi.helpet.helpetmobile.domain.executor.Executor;
import com.kincodi.helpet.helpetmobile.domain.executor.MainThread;
import com.kincodi.helpet.helpetmobile.domain.interactors.NewPostInteractor;
import com.kincodi.helpet.helpetmobile.domain.interactors.base.AbstractInteractor;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.repository.PostRepository;
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
    private String mLocation;
    private String mPersonContact;
    private String mPhone;
    private String mImages;
    private String mSpecies;
    private MainThread mMainThread;
    private NewPostInteractor.Callback mCallback;
    public NewPostInteractorImpl(Executor threadExecutor,
                                 MainThread mainThread,
                                 Callback callback,
                                 PostRepository postRepository,
                                 String name,String kind,
                                 String race, String description,
                                 String location,String personcontact,
                                 String phone, String images,
                                 String species) {
        super(threadExecutor, mainThread);
        mPostRepository = postRepository;
        mMainThread = mainThread;
        mCallback = callback;
        mName = name;
        mKind = kind;
        mRace = race;
        mDescription = description;
        mLocation = location;
        mPersonContact = personcontact;
        mPhone = phone;
        mImages = images;
        mSpecies = species;
    }
    @Override
    public void run() {
        Post post = new Post();
        post.setName(mName);
        post.setDescription(mDescription);
        post.setKind(mKind);
        post.setLocation(mLocation);
        post.setPhone(mPhone);
        post.setSpecies(mSpecies);
        post.setRace(mRace);
        post.setPerson_contact(mPersonContact);
        post.setImages(mImages);
        Response result = mPostRepository.create(post);
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
