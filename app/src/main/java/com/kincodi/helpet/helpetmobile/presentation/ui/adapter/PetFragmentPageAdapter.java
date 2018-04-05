package com.kincodi.helpet.helpetmobile.presentation.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.kincodi.helpet.helpetmobile.domain.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julio on 19/03/2018.
 */

public class PetFragmentPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mFragmentTitles = new ArrayList<>();

    public PetFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void resetFragments() {
        mFragments = new ArrayList<>();
        mFragmentTitles = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {return mFragments.get(position);}
    @Override
    public int getCount() {return mFragments.size();}
    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    public void reset() {
        mFragments = new ArrayList<>();
        mFragmentTitles = new ArrayList<>();
    }

    public void setFragments(List<Fragment> fragments) {
        mFragments = fragments;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

}
