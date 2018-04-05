package com.kincodi.helpet.helpetmobile.presentation.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PetFragmentPageAdapter;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.Detail.InfoFragment;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.Detail.MapFragment;

public class DetailActivity extends AppCompatActivity {
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        PetFragmentPageAdapter adapter = new PetFragmentPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new InfoFragment(), getString(R.string.title_info));
        adapter.addFragment(new MapFragment(), getString(R.string.title_map));
        viewPager.setAdapter(adapter);

    }
}
