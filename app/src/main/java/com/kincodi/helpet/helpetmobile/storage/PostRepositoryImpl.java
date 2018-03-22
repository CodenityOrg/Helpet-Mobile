package com.kincodi.helpet.helpetmobile.storage;

import android.util.Log;

import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.model.User;
import com.kincodi.helpet.helpetmobile.domain.repository.PostRepository;
import com.kincodi.helpet.helpetmobile.network.Post.APIPostRest;
import com.kincodi.helpet.helpetmobile.network.RestClient;

import java.io.IOException;

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
    @Override public Response create(Post post) {
        try{
            Call call = API.create(post);
            Log.d("Create", String.valueOf(post));
            Response<Post> result = call.execute();
            return result;
        }catch (IOException e){
            Log.e("Error Exception",e.toString());
        }
        return null;
    }
}
