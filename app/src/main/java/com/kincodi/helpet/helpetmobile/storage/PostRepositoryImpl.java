package com.kincodi.helpet.helpetmobile.storage;

import android.util.Log;

import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.repository.PostRepository;
import com.kincodi.helpet.helpetmobile.network.Post.APIPostRest;
import com.kincodi.helpet.helpetmobile.network.RestClient;
import com.kincodi.helpet.helpetmobile.storage.sharedprederences.ConfigSharedPreferences;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

            MultipartBody.Part part;
            List<MultipartBody.Part> parts= new ArrayList();
            for (int i = 0; i<photoPaths.size();i++){
                File file = new File(photoPaths.get(i));
                part = MultipartBody.Part.createFormData("photos", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
                parts.add(part);
            }
            Call call = API.addPhoto(
                    parts,post.getName(),
                    post.getDescription(),
                    post.getAge(),post.getRace(),
                    post.getDate(),post.getPhone(),
                    post.getPosition());

            Response<ResponseBody> result =  call.execute();

            return result;
        }catch (IOException e){
            Log.e("Error Exception",e.toString());
        }
        return null;
    }
    @Override
    public Response getPosts(String type) {
        try{
            Call call = API.getPosts(type);
            Response<List<Post>> result =  call.execute();
            return result;
        }catch (IOException e){
            Log.e("Error Exception",e.toString());
        }
        return null;
    }
}
