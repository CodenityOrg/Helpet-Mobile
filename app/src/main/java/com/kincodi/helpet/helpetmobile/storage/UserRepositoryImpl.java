package com.kincodi.helpet.helpetmobile.storage;

import android.util.Log;

import com.kincodi.helpet.helpetmobile.domain.model.User;
import com.kincodi.helpet.helpetmobile.domain.repository.UserRepository;
import com.kincodi.helpet.helpetmobile.network.RestClient;
import com.kincodi.helpet.helpetmobile.network.User.APIUserRest;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Call;


/**
 * Created by Julio on 20/02/2018.
 */

public class UserRepositoryImpl implements UserRepository{

    private RestClient mRestClient;
    private APIUserRest API;

    public UserRepositoryImpl( ) {
        mRestClient  = new RestClient();
        API=mRestClient.getService(APIUserRest.class);
    }

    @Override
    public Response register(User user) {
        try{
            Call call = API.register(user);
            Response<User> result = call.execute();
            return result;
        }catch (IOException e){
            Log.e("Error Exception",e.toString());
        }
        return null;
    }

    @Override
    public Response login(User user) {
        try{
            Call call =  API.login(user);
            Response<User> result = call.execute();
            return result;
        }catch (IOException e){
            Log.e("Error Exception",e.toString());

        }
        return null;

    }

    @Override
    public Response loginOAuth(User user) {
        return null;
    }
}
