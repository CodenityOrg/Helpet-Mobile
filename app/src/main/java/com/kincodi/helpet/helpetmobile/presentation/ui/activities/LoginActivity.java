package com.kincodi.helpet.helpetmobile.presentation.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.presentation.presenters.LoginUserPresenter;

public class LoginActivity extends AppCompatActivity implements LoginUserPresenter.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onLogged() {

    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void loginNormal() {

    }
}
