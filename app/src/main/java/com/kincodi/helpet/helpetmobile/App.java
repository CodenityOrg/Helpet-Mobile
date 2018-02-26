package com.kincodi.helpet.helpetmobile;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.stripe.android.Stripe;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Julio on 20/02/2018.
 */

public class App extends Application {

    static App mApp;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mApp = this;
        MultiDex.install(this);

        new Stripe(this).setDefaultPublishableKey("pk_test_awBLLx6Mw9AnjQHR0z1456BN\n");

    }
    @Override
    public void onCreate() {
        super.onCreate();

        /*CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );*/
    }
    public static App getInstance() {
        return mApp;
    }
}
