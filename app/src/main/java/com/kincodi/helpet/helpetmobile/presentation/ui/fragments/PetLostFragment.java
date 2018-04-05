package com.kincodi.helpet.helpetmobile.presentation.ui.fragments;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PetFragmentPageAdapter;

public class PetLostFragment extends Fragment {
    ViewPager mViewPager;
    TabLayout tabs;
    public PetLostFragment() {}

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pet_lost, container, false);
        mViewPager = (ViewPager) v.findViewById(R.id.pager);
        tabs = (TabLayout) v.findViewById(R.id.tabs);
        setupViewPager(mViewPager);
        tabs.setupWithViewPager(mViewPager);
        return v;
    }

    private void setupViewPager(ViewPager viewPager) {
        PetFragmentPageAdapter adapter = new PetFragmentPageAdapter(getChildFragmentManager());
        adapter.addFragment(new ListPetsFragment(), getString(R.string.title_section1));
        adapter.addFragment(new MapPetsFragment(), getString(R.string.title_section2));
        viewPager.setAdapter(adapter);
    }
}
