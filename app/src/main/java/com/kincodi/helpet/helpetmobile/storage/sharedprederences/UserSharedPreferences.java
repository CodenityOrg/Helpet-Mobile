package com.kincodi.helpet.helpetmobile.storage.sharedprederences;

import android.content.Context;
import android.content.SharedPreferences;

import com.kincodi.helpet.helpetmobile.App;
import com.kincodi.helpet.helpetmobile.domain.model.User;

/**
 * Created by Julio on 20/02/2018.
 */

public class UserSharedPreferences {

    protected static SharedPreferences prefs = App.getInstance().getSharedPreferences("Shared Preferences", Context.MODE_PRIVATE);
    protected static SharedPreferences.Editor localEditor = prefs.edit();

    static public void saveUser(User user){
        localEditor.putString("name",user.getFirstName());
        localEditor.putString("lastname",user.getLastName());
        localEditor.putString("email",user.getEmail());
        localEditor.putString("password",user.getPassword());
        localEditor.putString("phone",user.getPhone());
        localEditor.commit();
    }
}
