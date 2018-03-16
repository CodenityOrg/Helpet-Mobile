package com.kincodi.helpet.helpetmobile.network.User;

import com.kincodi.helpet.helpetmobile.domain.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Julio on 20/02/2018.
 */

public interface APIUserRest {


    @POST("/login")
    Call<User> login(@Body User user);

    @POST("/login-oauth")
    Call<User> loginOAuth(@Body User user);

    @POST("/registro")
    Call<User> register(@Body User user);
}
