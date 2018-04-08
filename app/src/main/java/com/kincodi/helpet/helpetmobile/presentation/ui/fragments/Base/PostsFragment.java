package com.kincodi.helpet.helpetmobile.presentation.ui.fragments.Base;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.executor.impl.ThreadExecutor;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.presentation.presenters.GetListPostPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post.GetListPostPresenterImpl;
import com.kincodi.helpet.helpetmobile.presentation.ui.activities.NewPostActivity;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PostAdapter;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;
import com.kincodi.helpet.helpetmobile.threading.MainThreadImpl;

import java.util.ArrayList;
import java.util.List;

public class PostsFragment extends Fragment implements GetListPostPresenter.View {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager lManager;
    private FloatingActionButton fab;
    private PostRepositoryImpl postRepository;
    protected GetListPostPresenterImpl presenter;
    private PostAdapter postAdapter;
    private List<Post> posts = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        postRepository = new PostRepositoryImpl();

        presenter = new GetListPostPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                postRepository, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_pets, container, false);

        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), NewPostActivity.class);
                startActivity(i);
            }
        });

        postAdapter = new PostAdapter(posts);

        recycler = view.findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);
        recycler.setAdapter(postAdapter);

        return view;
    }

    @Override
    public void onSuccessGotPost(List<Post> posts) {
        postAdapter.addPosts(posts);
        postAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailedGotPost(String message) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}
