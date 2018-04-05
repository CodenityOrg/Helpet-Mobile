package com.kincodi.helpet.helpetmobile.network.Post;

import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.model.User;

import java.util.Date;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Julio on 20/02/2018.
 */

public interface APIPostRest {
    @POST("/posts")
    Call<Post> create(@Body Post post);

    @Multipart
    @POST("posts")
    Call<ResponseBody> addPhoto(
            @Part List<MultipartBody.Part> photos,
            @Part("name") String name,
            @Part("description") String description,
            @Part("age") String age,
            @Part("race") String race,
            @Part("date") Date date,
            @Part("cellphone") String cellphone,
            @Part("position") Double[] position);

    @Multipart @POST("posts")
    Call<ResponseBody> createPost(
            @Part List<MultipartBody.Part> photos,
            @Part("name") String name);


    @GET("/posts")
    Call<List<Post>> getPosts(@Query("type") String type);

    @GET("/posts/{id}")
    Call<Post> getPost(@Path("id") String id);

}
