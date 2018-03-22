package com.kincodi.helpet.helpetmobile.presentation.ui.activities;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.EditText;
import android.widget.Toast;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.executor.impl.ThreadExecutor;
import com.kincodi.helpet.helpetmobile.domain.repository.PostRepository;
import com.kincodi.helpet.helpetmobile.domain.repository.UserRepository;
import com.kincodi.helpet.helpetmobile.presentation.presenters.NewPostPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post.NewPostPresenterImpl;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.ImageAdapter;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.KindDialogFragment;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;
import com.kincodi.helpet.helpetmobile.threading.MainThreadImpl;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;
import droidninja.filepicker.utils.Orientation;

/**
 * Created by Julio on 19/03/2018.
 */

public class NewPostActivity extends AppCompatActivity implements NewPostPresenter.View {

    private NewPostPresenterImpl newPostPresenter;
    private PostRepository postRepository;
    ProgressDialog progressDialog;
    @BindView(R.id.edtName) EditText edtName;

    private int MAX_ATTACHMENT_COUNT = 10;
    private ArrayList<String> photoPaths = new ArrayList<>();
    private ArrayList<String> docPaths = new ArrayList<>();
    private static final int PICK_FROM_GALLERY = 1;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        postRepository = new PostRepositoryImpl();

        initPresenters();
        ButterKnife.bind(this);
    }
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case FilePickerConst.REQUEST_CODE_PHOTO:
                if (resultCode == Activity.RESULT_OK && data != null) {
                    photoPaths = new ArrayList<>();
                    photoPaths.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA));
                }
                break;
        }
        addThemToView(photoPaths);
    }
    private void addThemToView(ArrayList<String> imagePaths) {
        ArrayList<String> filePaths = new ArrayList<>();
        if (imagePaths != null) filePaths.addAll(imagePaths);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        if (recyclerView != null) {
            StaggeredGridLayoutManager layoutManager =
                    new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL);
            layoutManager.setGapStrategy(
                    StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
            recyclerView.setLayoutManager(layoutManager);
            ImageAdapter imageAdapter = new ImageAdapter(this, filePaths);
            recyclerView.setAdapter(imageAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }
    @OnClick(R.id.btnImg1)
    public void pickPhotoClicked() {
        try {
            if (ActivityCompat.checkSelfPermission(NewPostActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(NewPostActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PICK_FROM_GALLERY);
            } else {
                onPickPhoto();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onPickPhoto() {
        int maxCount = MAX_ATTACHMENT_COUNT - docPaths.size();
        if ((docPaths.size() + photoPaths.size()) == MAX_ATTACHMENT_COUNT) {
            Toast.makeText(this, "Cannot select more than " + MAX_ATTACHMENT_COUNT + " items",
                    Toast.LENGTH_SHORT).show();
        } else {
            FilePickerBuilder.getInstance()
                    .setMaxCount(maxCount)
                    .setSelectedFiles(photoPaths)
                    .setActivityTheme(R.style.FilePickerTheme)
                    .setActivityTitle("Por favor selecciona una imagen")
                    .enableVideoPicker(true)
                    .enableCameraSupport(true)
                    .showGifs(false)
                    .showFolderView(false)
                    .enableSelectAll(true)
                    .enableImagePicker(true)
                    .setCameraPlaceholder(R.mipmap.ic_launcher)
                    .withOrientation(Orientation.UNSPECIFIED)
                    .pickPhoto(this);
        }
    }
    //@OnClick(R.id.snpKind)
    public void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        KindDialogFragment kindDialogFragment = KindDialogFragment.newInstance("Some Title");
        kindDialogFragment.show(fm, "fragment_edit_name");
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
    public void onCreated() {
        hideProgress();
        setResult(Activity.RESULT_OK);
        finish();
        Intent i = new Intent(this,PostActivity.class);
        startActivity(i);
    }

    @Override
    public void onFailed(String message) {
        hideProgress();
        showError(message);
    }

    @Override
    public void createNormal() {

    }
    public void initPresenters(){
        newPostPresenter = new NewPostPresenterImpl(ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),this,postRepository);
    }
}
