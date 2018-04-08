package com.kincodi.helpet.helpetmobile.presentation.ui.fragments;

import android.os.Bundle;

import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.Base.PostsFragment;

public class ListPetsLostFragment extends PostsFragment {

    public ListPetsLostFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.getPosts(0);
    }

}
