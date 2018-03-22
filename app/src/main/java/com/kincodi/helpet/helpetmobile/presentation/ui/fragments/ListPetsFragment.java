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
import com.kincodi.helpet.helpetmobile.presentation.ui.activities.NewPostActivity;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;


public class ListPetsFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private FloatingActionButton fab;
    final List items = new ArrayList();
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

        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);
        items.add(new Post("AAAAAAAAAAA","DESCRIPTION","PERRITO PERDIDO","ciudad nueva"));
        items.add(new Post("AAAAAAAAAAA","DESCRIPTION","PERRITO PERDIDO","ciudad nueva"));
        items.add(new Post("AAAAAAAAAAA","DESCRIPTION","PERRITO PERDIDO","ciudad nueva"));
        items.add(new Post("AAAAAAAAAAA","DESCRIPTION","PERRITO PERDIDO","ciudad nueva"));

        adapter = new PostAdapter(items);
        recycler.setAdapter(adapter);
        return view;


    }
}
