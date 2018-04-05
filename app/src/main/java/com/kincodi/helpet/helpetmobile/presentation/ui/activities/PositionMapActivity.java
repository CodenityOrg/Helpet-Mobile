package com.kincodi.helpet.helpetmobile.presentation.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.presentation.presenters.NewPostPresenter;

public class PositionMapActivity extends AppCompatActivity implements OnMapReadyCallback{
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private static final int PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 2;
    GoogleMap googleMap;
    SupportMapFragment mapFragment;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_map);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapPosition);
        mapFragment.getMapAsync(this);
    }

    Marker userMarker;
    private BottomSheetBehavior behavior;

    @Override public void onMapReady(GoogleMap map) {
        googleMap = map;


        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                /*Projection proj = googleMap.getProjection();
                int zoom = (int) googleMap.getCameraPosition().zoom;
                Point point = proj.toScreenLocation(marker.getPosition());



                Log.d("ZOON", String.valueOf(center));

                point.y = point.y +  mapFragment.getView().getMeasuredHeight()/(8*zoom);
                LatLng position = proj.fromScreenLocation(point);
                */
                LatLng center = googleMap.getCameraPosition().target;
                preStart(center);
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(center, 15);
                googleMap.animateCamera(cameraUpdate);
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                return true;
            }
        });

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            }
        }
    }

    public void preStart(LatLng latLng){
        Intent i = new Intent(this,NewPostPresenter.class);
        i.putExtra("position",latLng);
        startActivity(i);
        finish();
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}