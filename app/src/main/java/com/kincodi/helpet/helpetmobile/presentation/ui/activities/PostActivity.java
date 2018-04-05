package com.kincodi.helpet.helpetmobile.presentation.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PetFragmentPageAdapter;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.ListPetsFragment;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.MapPetsFragment;

public class PostActivity extends AppCompatActivity {

    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);





        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        PetFragmentPageAdapter adapter = new PetFragmentPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ListPetsFragment(), getString(R.string.title_section1));
        adapter.addFragment(new MapPetsFragment(), getString(R.string.title_section2));
        viewPager.setAdapter(adapter);
    }
}
