package com.kincodi.helpet.helpetmobile.presentation.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post.GetListPostPresenterImpl;
import com.kincodi.helpet.helpetmobile.presentation.ui.activities.NewPostActivity;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PostAdapter;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPetsFoundFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager lManager;
    private FloatingActionButton fab;
    private PostRepositoryImpl postRepository;
    private GetListPostPresenterImpl presenter;
    private List<Post> mPosts = new ArrayList<>();
    private PostAdapter postAdapter;

    public ListPetsFoundFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_pets_found, container, false);
        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), NewPostActivity.class);
                startActivity(i);
            }
        });
        recycler = view.findViewById(R.id.recycler2);
        recycler.setHasFixedSize(true);
        postRepository = new PostRepositoryImpl();
        postAdapter = new PostAdapter(mPosts);
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);
        recycler.setAdapter(postAdapter);
        return view;
    }

}
