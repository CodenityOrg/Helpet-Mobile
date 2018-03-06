package com.kincodi.helpet.helpetmobile.presentation.ui.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.executor.impl.ThreadExecutor;
import com.kincodi.helpet.helpetmobile.domain.repository.UserRepository;
import com.kincodi.helpet.helpetmobile.helpers.Validation;
import com.kincodi.helpet.helpetmobile.presentation.presenters.LoginUserPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.User.LoginUserPresenterImpl;
import com.kincodi.helpet.helpetmobile.storage.UserRepositoryImpl;
import com.kincodi.helpet.helpetmobile.threading.MainThreadImpl;

public class LoginActivity extends AppCompatActivity implements LoginUserPresenter.View{
    EditText edtEmail,edtPassword;
    private LoginUserPresenterImpl loginUserPresenter;
    ProgressDialog progressDialog;
    private UserRepository userRepository;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        userRepository = new UserRepositoryImpl();
        initPresenters();
    }
    public void initPresenters(){
        loginUserPresenter = new LoginUserPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this, userRepository);
    }
        @Override public void onLogged() {
        hideProgress();
        setResult(Activity.RESULT_OK);
        finish();
        Intent i = new Intent(this,MapActivity.class);
        startActivity(i);
    }
    @Override public void onFailed(String message) {
        hideProgress();
        showError(message);
    }
    @Override public void loginNormal() {
        if(Validation.isOnline()){
            String email = edtEmail.getText().toString();
            String password = edtPassword.getText().toString();
            showProgress();
            loginUserPresenter.login(email,password);
        }else
            Validation.showNoConnectionDialog(this);
    }
    @Override public void showProgress() {
        progressDialog.setMessage(getString(R.string.login_loading));
        progressDialog.show();
    }
    @Override public void hideProgress() {
        progressDialog.hide();
    }
    @Override public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
