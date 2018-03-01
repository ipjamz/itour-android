package com.peterjamesbabiera.itour_android.views.fragments;

import android.Manifest;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.peterjamesbabiera.itour_android.R;

/**
 * Created by peter on 2/14/18.
 */

public class MapFragment extends Fragment implements GoogleMap.OnMarkerClickListener, GoogleMap.OnMyLocationChangeListener, DialogInterface.OnClickListener {

    private View mMainView;
    private MapView mMapView;

    private GoogleMap mGoogleMap;
    private Location currentLocation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.fragment_map, container, false);
        return mMainView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = mMainView.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        initMap();
    }

    @Override
    public void onResume() {
        super.onResume();
        onReloadMap(currentLocation);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMyLocationChange(Location location) {
        double distance = 0;
        if (currentLocation != null) {
            distance = currentLocation.distanceTo(location);
        }
        if (currentLocation == null || currentLocation.getLatitude() != location.getLatitude() && currentLocation.getLongitude() != location.getLongitude()) {
            if (distance == 0 || distance > 2000) {
                if (location == null) {
                    currentLocation = new Location("default");
                } else {
                    currentLocation = location;
                }
                onReloadMap(location);
            }
        }
    }

    private void initMap() {
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mGoogleMap = googleMap;
                mGoogleMap.getUiSettings().setMapToolbarEnabled(false);
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                mGoogleMap.setMyLocationEnabled(true);
                mGoogleMap.setOnMarkerClickListener(MapFragment.this);
                mGoogleMap.setOnMyLocationChangeListener(MapFragment.this);

            }
        });
    }

    private void onReloadMap(Location location) {
        if (location != null) {
            CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude()));
            CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);
            mGoogleMap.moveCamera(center);
            mGoogleMap.animateCamera(zoom);
            if (checkLocationPermission()) {
            }
        }
    }

    protected boolean checkLocationPermission() {
        if ((ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED)) {
            String[] permissions = new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.ACCESS_FINE_LOCATION};
            ActivityCompat.requestPermissions(getActivity(), permissions, 12345);
            return false;
        } else {
            final LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                return true;
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(R.string.exit)
                        .setPositiveButton(R.string.confirm, this)
                        .setNegativeButton(R.string.cancel, this)
                        .show();
                return false;
            }
        }
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        onViewLocationSourceSetting();
    }

    private void onViewLocationSourceSetting() {
        Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
    }
}
