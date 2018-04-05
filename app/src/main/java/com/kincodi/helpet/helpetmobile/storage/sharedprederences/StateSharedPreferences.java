package com.kincodi.helpet.helpetmobile.storage.sharedprederences;

import android.content.Context;
import android.content.SharedPreferences;

import com.kincodi.helpet.helpetmobile.App;

/**
 * Created by Julio on 20/02/2018.
 */

public class StateSharedPreferences {


    static public void setStatus(int status){
        localEditor.putInt("status",status);
        localEditor.commit();
    }

    static public int getStatus(){
        return prefs.getInt("status",0);
    }

    static SharedPreferences prefs = App.getInstance().getSharedPreferences("Shared Preferences", Context.MODE_PRIVATE);
    static SharedPreferences.Editor localEditor = prefs.edit();


    static public void setIsAvailable(boolean available){
        localEditor.putBoolean("available",available);
        localEditor.commit();
    }

    static public boolean isAvailable(){
        return prefs.getBoolean("available",false);
    }

}
