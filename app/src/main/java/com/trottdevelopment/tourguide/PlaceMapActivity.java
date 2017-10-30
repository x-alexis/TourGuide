package com.trottdevelopment.tourguide;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.trottdevelopment.tourguide.R.id.map;

public class PlaceMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Bundle mIncomeBundle;
    private LatLng mLocation;
    private int mPlaceTitleRecourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);

        //Adding "Up" button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Making "Back button" work properly
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
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

        //Getting bundle and LatLng
        mIncomeBundle = getIntent().getParcelableExtra("bundle");
        mLocation = mIncomeBundle.getParcelable("location");
        mPlaceTitleRecourceId = mIncomeBundle.getInt("title");

        // Add a marker in placeLocation and move the camera
        mMap.addMarker(new MarkerOptions()
                .position(mLocation)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title(getResources().getString(mPlaceTitleRecourceId))).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mLocation));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
    }
}
