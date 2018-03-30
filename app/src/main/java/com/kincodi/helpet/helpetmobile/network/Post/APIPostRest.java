package com.kincodi.helpet.helpetmobile.network.Post;

import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.model.User;

import java.util.Date;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Julio on 20/02/2018.
 */

public interface APIPostRest {
    @POST("/posts")
    Call<Post> create(@Body Post post);

    @Multipart
    @POST("gallery/add-photo")
    Call<ResponseBody> addPhoto(
            @Part MultipartBody.Part file,
            @Part("name") String name,
            @Part("description") String description,
            @Part("age") String age,
            @Part("race") String race,
            @Part("date") Date date,
            @Part("cellphone") String cellphone,
            @Part("position") String position);

    @Multipart @POST("posts")
    Call<ResponseBody> createPost(@Body MultipartBody file, @Part("post") Post post);

}
