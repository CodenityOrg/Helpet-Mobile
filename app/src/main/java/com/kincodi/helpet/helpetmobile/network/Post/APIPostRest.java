package com.kincodi.helpet.helpetmobile.network.Post;

import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Julio on 20/02/2018.
 */

public interface APIPostRest {
    @POST("/posts")
    Call<Post> create(@Body Post post);

}
