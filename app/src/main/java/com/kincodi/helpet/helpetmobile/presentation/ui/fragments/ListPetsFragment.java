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
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.domain.repository.PostRepository;
import com.kincodi.helpet.helpetmobile.presentation.presenters.GetListPostPresenter;
import com.kincodi.helpet.helpetmobile.presentation.ui.activities.DetailActivity;
import com.kincodi.helpet.helpetmobile.presentation.ui.activities.NewPostActivity;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PostAdapter;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ListPetsFragment extends Fragment implements GetListPostPresenter.View{

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private FloatingActionButton fab;
    final List items = new ArrayList();
    ProgressDialog progressDialog;
    private PostRepository postRepository;

    public ListPetsFragment() {
    }
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
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

        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);


        return view;


    }

    @Override public void showProgress() {
        progressDialog.setMessage(getString(R.string.login_loading));
        progressDialog.show();
    }

    @Override public void hideProgress() {
        progressDialog.hide();

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccessGotPost(List<Post> posts) {
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);
        recycler.setAdapter(new PostAdapter(posts, new PostAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Post item) {
                Post post = new Post(item.getName(),item.getDescription(),item.getRace(),item.getKind(),
                        item.getAge(),
                        item.getDate(),
                        item.getPosition(),
                        item.getPhone());
                Toast.makeText(getActivity(), "Item Clicked", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(),DetailActivity.class);
                i.putExtra("post", post);
                startActivity(i);
            }
        }));
    }

    @Override
    public void onFailedGotPost(String message) {
        hideProgress();
        showError(message);
    }
}
