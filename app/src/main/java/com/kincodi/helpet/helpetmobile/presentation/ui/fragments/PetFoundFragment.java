package com.kincodi.helpet.helpetmobile.presentation.ui.fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kincodi.helpet.helpetmobile.R;
public class PetFoundFragment extends Fragment {
    public PetFoundFragment() {}
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_pet_found, container, false);
    }
}
