package com.kincodi.helpet.helpetmobile.presentation.presenters;

import com.kincodi.helpet.helpetmobile.presentation.ui.BaseView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Julio on 19/03/2018.
 */

public interface NewPostPresenter {
    interface View extends BaseView {
        void onCreated();
        void onFailed(String message);
        void createNormal() throws JSONException;
    }
    void createPost(String name,
                    String description,
                    String race,
                    String age,
                    String kind,
                    Date date,
                    Double[] position,
                    String phone,
                    ArrayList<String> file);
}
