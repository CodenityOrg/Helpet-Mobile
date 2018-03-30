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

    static public void saveConfig(String remToken, String confToken){
        localEditor.putString("remToken",remToken);
        localEditor.putString("confToken",confToken);
        localEditor.commit();
    }


    static public void saveRembToken(String rembToken){
        localEditor.putString("rembToken",rembToken);
        localEditor.commit();
    }

    static public void saveConfToken(String confToken){
        localEditor.putString("confToken",confToken);
        localEditor.commit();
    }

    static public String restoreConfToken(){
        return prefs.getString("confToken","");
    }

    static public String restoreRembToken(){
        return prefs.getString("rembToken","");
    }

}
