package com.kincodi.helpet.helpetmobile.presentation.ui.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.executor.impl.ThreadExecutor;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.repository.PostRepository;
import com.kincodi.helpet.helpetmobile.presentation.presenters.GetListPostPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post.GetListPostPresenterImpl;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.User.RegisterUserPresenterImpl;
import com.kincodi.helpet.helpetmobile.presentation.ui.activities.DetailActivity;
import com.kincodi.helpet.helpetmobile.presentation.ui.activities.NewPostActivity;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PostAdapter;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;
import com.kincodi.helpet.helpetmobile.threading.MainThreadImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ListPetsLostFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager lManager;
    private FloatingActionButton fab;
    private PostRepositoryImpl postRepository;
    private GetListPostPresenterImpl presenter;
    private List<Post> mPosts = new ArrayList<>();
    private PostAdapter postAdapter = new PostAdapter(mPosts);

    public ListPetsLostFragment() {
    }



    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_pets, container, false);


        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), NewPostActivity.class);
                startActivity(i);

            }
        });

        recycler = view.findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        postRepository = new PostRepositoryImpl();
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);
        recycler.setAdapter(postAdapter);

        return view;
    }


    public void addPosts(List<Post> posts) {
        postAdapter.addPosts(posts);
        postAdapter.notifyDataSetChanged();
    }


}
