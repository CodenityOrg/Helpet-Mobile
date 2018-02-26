package com.kincodi.helpet.helpetmobile.domain.repository;

import com.kincodi.helpet.helpetmobile.domain.model.User;


import retrofit2.Response;
/**
 * Created by Julio on 20/02/2018.
 */

public interface UserRepository {

    Response register (User user);
    Response login (User user);
    Response loginOAuth(User user);
}
