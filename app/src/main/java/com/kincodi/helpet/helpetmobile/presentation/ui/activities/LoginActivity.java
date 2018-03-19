package com.kincodi.helpet.helpetmobile.presentation.ui.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginUserPresenter.View{
    @BindView(R.id.edtEmail) EditText edtEmail;
    @BindView(R.id.edtPassword) EditText edtPassword;

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
        ButterKnife.bind(this);
    }
    public void initPresenters(){
        loginUserPresenter = new LoginUserPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this, userRepository);
    }
    @Override public void onLogged() {
        Log.d("sdfasdfsafsd","sdfsdfasdfsd");
        hideProgress();
        setResult(Activity.RESULT_OK);
        finish();
        Intent i = new Intent(this,PostActivity.class);
        startActivity(i);
    }
    @Override public void onFailed(String message) {
        hideProgress();
        showError(message);
    }
    @OnClick(R.id.btnSigIn)
    @Override public void loginNormal() {
            String email = edtEmail.getText().toString();
            String password = edtPassword.getText().toString();
            showProgress();
            loginUserPresenter.login(email,password);

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
    @OnClick(R.id.btnSignUp)
    public void SingUp(){
        Intent i = new Intent(this,RegisterActivity.class);
        startActivity(i);
    }
}
