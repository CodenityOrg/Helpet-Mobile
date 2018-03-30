package com.kincodi.helpet.helpetmobile.storage;

import android.util.Log;

import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.repository.PostRepository;
import com.kincodi.helpet.helpetmobile.network.Post.APIPostRest;
import com.kincodi.helpet.helpetmobile.network.RestClient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;


/**
 * Created by Julio on 20/02/2018.
 */

public class PostRepositoryImpl implements PostRepository {
    private RestClient mRestClient;
    private APIPostRest API;

    public PostRepositoryImpl( ) {
        mRestClient  = new RestClient();
        API=mRestClient.getService(APIPostRest.class);
    }

    @Override public Response create(ArrayList<String> photoPaths, Post post) {

        try{
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);

            for (int i = 0; i < photoPaths.size(); i++) {
                File file = new File(photoPaths.get(i));
                builder.addFormDataPart("file[]", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
            }

            MultipartBody body = builder.build();
            Call call = API.createPost(body,post);
            Response<ResponseBody> result =  call.execute();
            return result;
        }catch (IOException e){
            Log.e("Error Exception",e.toString());
        }
        return null;
    }
}
