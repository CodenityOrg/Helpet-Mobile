package com.kincodi.helpet.helpetmobile.presentation.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.presentation.ui.activities.LoginActivity;
import com.kincodi.helpet.helpetmobile.presentation.ui.activities.RegisterActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {


    public MoreFragment() {
        // Required empty public constructor
    }
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_more, container, false);

        return view;
    }
    public void OnclickLogin(View view){
        Intent i = new Intent(getActivity(), LoginActivity.class);
        startActivity(i);
    }
    public void OnclickRegister(View view){
        Intent i = new Intent(getActivity(), RegisterActivity.class);
        startActivity(i);
    }

}
