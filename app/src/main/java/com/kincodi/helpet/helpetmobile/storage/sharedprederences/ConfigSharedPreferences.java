package com.kincodi.helpet.helpetmobile.storage.sharedprederences;

import android.content.Context;
import android.content.SharedPreferences;

import com.kincodi.helpet.helpetmobile.App;

/**
 * Created by Julio on 20/02/2018.
 */

public class ConfigSharedPreferences {
    protected static SharedPreferences prefs = App.getInstance().getSharedPreferences("Shared Preferences", Context.MODE_PRIVATE);
    protected static SharedPreferences.Editor localEditor = prefs.edit();

    static public void saveConfig(String remToken){
        localEditor.putString("Authorization",remToken);
        localEditor.commit();
    }

    static public String restoreToken(){
        return prefs.getString("Authorization","");
    }

}
