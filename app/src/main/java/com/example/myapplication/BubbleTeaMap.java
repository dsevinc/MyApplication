package com.example.myapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class BubbleTeaMap extends FragmentActivity implements OnMyLocationButtonClickListener,
        OnMyLocationClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng myPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_tea_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        UiSettings mapSettings;

        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);


        // Add a marker in Ottawa and move the camera
        LatLng ottawa = new LatLng(45.42170, -75.681500);
        LatLng CoCo = new LatLng(45.4155275, -75.6970247);
        LatLng chatime = new LatLng(45.4114658, -75.7082453);
        LatLng chatime2 = new LatLng(45.4274647,-75.6918967);
        LatLng presotea = new LatLng(45.4270942,-75.691516);
        LatLng sharetea = new LatLng(45.4269664,-75.6915364);

        mMap.addMarker(new MarkerOptions().position(ottawa).title("Marker in Ottawa"));
        mMap.addMarker(new MarkerOptions().position(CoCo).title("CoCo"));
        mMap.addMarker(new MarkerOptions().position(chatime).title("Chatime Somerset"));
        mMap.addMarker(new MarkerOptions().position(presotea).title("Presotea"));
        mMap.addMarker(new MarkerOptions().position(chatime2).title("Chatime Byward"));
        mMap.addMarker(new MarkerOptions().position(sharetea).title("ShareTea"));



//      mMap.moveCamera(CameraUpdateFactory.newLatLng(ottawa));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ottawa,(mMap.getMaxZoomLevel ())-3));

    }
    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }
}
