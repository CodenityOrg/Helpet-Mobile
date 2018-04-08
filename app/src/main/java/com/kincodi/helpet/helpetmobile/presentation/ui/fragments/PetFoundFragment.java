package com.kincodi.helpet.helpetmobile.presentation.ui.fragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.executor.impl.ThreadExecutor;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.presentation.presenters.GetListPostPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post.GetListPostPresenterImpl;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PetFragmentPageAdapter;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;
import com.kincodi.helpet.helpetmobile.threading.MainThreadImpl;

import java.util.List;

public class PetFoundFragment extends Fragment {

    ViewPager mViewPager;
    TabLayout tabs;

    public PetFoundFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pet_found, container, false);
        mViewPager = v.findViewById(R.id.pager);
        tabs = v.findViewById(R.id.tabs);
        setupViewPager(mViewPager);
        tabs.setupWithViewPager(mViewPager);

        return v;
    }

    private void setupViewPager(ViewPager viewPager) {
        //adapter = new PetFragmentPageAdapter(getChildFragmentManager());
        PetFragmentPageAdapter adapter = new PetFragmentPageAdapter(getChildFragmentManager());

        adapter.addFragment(new ListPetsFoundFragment(), getString(R.string.title_section1));
        adapter.addFragment(new MapPetsFoundFragment(), getString(R.string.title_section2));
        viewPager.setAdapter(adapter);
    }


}
