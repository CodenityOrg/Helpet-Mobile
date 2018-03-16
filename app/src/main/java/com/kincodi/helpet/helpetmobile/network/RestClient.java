package com.kincodi.helpet.helpetmobile.network;

import com.kincodi.helpet.helpetmobile.storage.sharedprederences.ConfigSharedPreferences;
import com.kincodi.helpet.helpetmobile.storage.sharedprederences.UserSharedPreferences;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Julio on 20/02/2018.
 */

public class RestClient {

    /**
     * This is our main backend/server URL.
     */
    public static final String REST_API_URL = "https://helpet-webapp.herokuapp.com";

    private static Retrofit s_retrofit;



    static {

        // enable logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //SmartCallFactory smartFactory = new SmartCallFactory(BasicCaching.fromCtx(this));


        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60,TimeUnit.SECONDS)
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Interceptor.Chain chain) throws IOException {
                                Request request = chain.request().newBuilder()
                                        //.addHeader("api-token", ConfigSharedPreferences.restoreRembToken())
                                        //.addHeader("user-id", UserSharedPreferences.restoreUser().getId() + "")
                                        .build();
                                //Response originalResponse = chain.proceed(request);



                                return chain.proceed(request);
                            }
                        }
                ).build();



        s_retrofit = new Retrofit.Builder()
                .baseUrl(REST_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }



    public static <T> T getService(Class<T> serviceClass) {
        return s_retrofit.create(serviceClass);
    }

}
