package com.kincodi.helpet.helpetmobile.network.User;

import com.kincodi.helpet.helpetmobile.domain.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by Julio on 20/02/2018.
 */

public interface APIUserRest {


    @POST("/api/login")
    Call<User> login(@Body User user);

    @POST("/api/login-oauth")
    Call<User> loginOAuth(@Body User user);

    @POST("/api/users")
    Call<User> register(@Body User user);

    @PUT("/api/users/firebase-token")
    Call<ResponseBody> updateFireBaseId(@Query("firebaseToken") String firebaseToken);

}
