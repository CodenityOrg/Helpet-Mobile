package com.kincodi.helpet.helpetmobile.storage.sharedprederences;

import android.content.Context;
import android.content.SharedPreferences;
import com.kincodi.helpet.helpetmobile.App;
import com.kincodi.helpet.helpetmobile.domain.model.User;

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

    static public boolean logged(){
        return prefs.getBoolean("login",false);
    }
    static public void setLogged(boolean login){
        localEditor.putBoolean("login",login);
        localEditor.commit();
    }
    static public String getFireBaseId(){
        return prefs.getString("firebaseId","");
    }

    static public void setFireBaseId(String firebaseId){
        localEditor.putString("firebaseId",firebaseId);
        localEditor.commit();
    }



    static public User restoreUser(){
        User user = new User();

        user.setId(prefs.getString("id",""));
        user.setFirstName(prefs.getString("name",""));
        user.setLastName(prefs.getString("lastname",""));
        user.setEmail(prefs.getString("email",""));
        user.setPhone(prefs.getString("phone",""));
        return user;
    }
    static public void setLatitude(String latitude){
        localEditor.putString("latitude",latitude);
        localEditor.commit();
    }
    static public void setLongitude(String longitude){
        localEditor.putString("longitude",longitude);
        localEditor.commit();
    }
    static public String getLatitude(){
        return prefs.getString("latitude","0");
    }
    static public String getLongitude(){
        return prefs.getString("longitude","0");
    }
    static public void logout(){
        localEditor.clear().commit();
    }
}
