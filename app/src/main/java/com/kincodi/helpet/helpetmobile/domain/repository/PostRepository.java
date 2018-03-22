package com.kincodi.helpet.helpetmobile.domain.repository;

import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.model.User;

import retrofit2.Response;

/**
 * Created by Julio on 20/02/2018.
 */

public interface PostRepository {

    Response create (Post post);
}
