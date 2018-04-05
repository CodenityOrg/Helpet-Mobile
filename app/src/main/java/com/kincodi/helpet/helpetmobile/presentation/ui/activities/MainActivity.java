package com.kincodi.helpet.helpetmobile.presentation.ui.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PetFragmentPageAdapter;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.ListPetsFragment;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.MapPetsFragment;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.MoreFragment;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.PetFoundFragment;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.PetLostFragment;

public class MainActivity extends AppCompatActivity{
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_lost:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_found:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_more:
                                viewPager.setCurrentItem(2);
                        }
                        return false;
                    }
                });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override public void onPageSelected(int position) {}
            @Override public void onPageScrollStateChanged(int state) {}
        });
        setupViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        PetFragmentPageAdapter adapter = new PetFragmentPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new PetLostFragment(), getString(R.string.title_section1));
        adapter.addFragment(new PetFoundFragment(), getString(R.string.title_section2));
        adapter.addFragment(new MoreFragment(),getString(R.string.title_seccion3));
        viewPager.setAdapter(adapter);
    }
}
