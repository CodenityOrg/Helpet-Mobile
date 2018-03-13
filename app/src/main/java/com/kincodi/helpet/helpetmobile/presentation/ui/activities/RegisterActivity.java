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
import com.kincodi.helpet.helpetmobile.presentation.presenters.RegisterUserPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.User.LoginUserPresenterImpl;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.User.RegisterUserPresenterImpl;
import com.kincodi.helpet.helpetmobile.storage.UserRepositoryImpl;
import com.kincodi.helpet.helpetmobile.threading.MainThreadImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegisterUserPresenter.View{

    @BindView(R.id.edtName) EditText edtName;
    @BindView(R.id.edtLastName) EditText edtLastName;
    @BindView(R.id.edtPhone) EditText edtPhone;
    @BindView(R.id.edtEmail) EditText edtEmail;
    @BindView(R.id.edtPassword) EditText edtPassword;

    private UserRepository userRepository;
    ProgressDialog progressDialog;
    private RegisterUserPresenterImpl registerUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        userRepository = new UserRepositoryImpl();
        initPresenters();
    }
    public void initPresenters(){
        registerUserPresenter = new RegisterUserPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this, userRepository);
    }
    @Override
    public void showProgress() {
        progressDialog.setMessage(getString(R.string.login_loading));
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRegistered() {
        hideProgress();
        setResult(Activity.RESULT_OK);
        finish();
        Intent i = new Intent(this,MapActivity.class);
        startActivity(i);
    }

    @Override
    public void onFailed(String message) {
        hideProgress();
        showError(message);
    }
    @OnClick(R.id.btnSignUp)
    @Override public void registerNormal() {
        String name = edtName.getText().toString();
        String lastName = edtLastName.getText().toString();
        String phone    = edtPhone.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        showProgress();
        registerUserPresenter.register(name,lastName,phone,email,password);
    }
}
