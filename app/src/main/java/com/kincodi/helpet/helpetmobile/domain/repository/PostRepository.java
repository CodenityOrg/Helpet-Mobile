package com.kincodi.helpet.helpetmobile.domain.repository;

import com.kincodi.helpet.helpetmobile.domain.model.Post;

import java.io.File;
import java.util.ArrayList;

import retrofit2.Response;

/**
 * Created by Julio on 20/02/2018.
 */

public interface PostRepository {

    Response getPosts();
    Response create (ArrayList<String> file, Post post);
}
