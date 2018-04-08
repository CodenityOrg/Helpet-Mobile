package com.kincodi.helpet.helpetmobile.presentation.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.Base.PostsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPetsFoundFragment extends PostsFragment {

    public ListPetsFoundFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.getPosts(1);
    }

}
