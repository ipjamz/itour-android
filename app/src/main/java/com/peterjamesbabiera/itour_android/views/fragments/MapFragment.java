package com.peterjamesbabiera.itour_android.views.fragments;

import android.Manifest;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.peterjamesbabiera.itour_android.R;
import com.peterjamesbabiera.itour_android.data.Attraction;
import com.peterjamesbabiera.itour_android.logic.AttractionLogic;
import com.peterjamesbabiera.itour_android.views.activities.DetailedSiteActivity;
import com.peterjamesbabiera.itour_android.views.fragments.site.SiteFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 2/14/18.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback, LocationListener, DialogInterface.OnClickListener, GoogleMap.OnMarkerClickListener {

    private View mMainView;
    private MapView mMapView;

    private GoogleMap mGoogleMap;
    private LocationManager mLocationManager;
    private List<Marker> mMarkers = new ArrayList<>();

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

        mMapView.getMapAsync(this);

        mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (checkLocationPermission()) {
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
            mLocationManager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, this);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        if (checkLocationPermission()) {
            mGoogleMap.setMyLocationEnabled(true);
        }
        mGoogleMap.setOnMarkerClickListener(this);
        showNearbySites();
    }

    @Override
    public void onLocationChanged(Location location) {
        Marker marker = mGoogleMap.addMarker(new MarkerOptions()
                .position(new LatLng(location.getLatitude(), location.getLongitude()))
                .title(getString(R.string.current_location)));
        mMarkers.add(marker);
        mGoogleMap.setMaxZoomPreference(15);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 15));
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case DialogInterface.BUTTON_POSITIVE:
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                dialogInterface.cancel();
                break;
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Attraction site = (Attraction) marker.getTag();
        if (site == null) {
        } else {
            Intent intent = new Intent(getActivity(), DetailedSiteActivity.class);
            intent.putExtra(SiteFragment.SITE, site);
            startActivity(intent);
        }
        return false;
    }

    private boolean checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.permission_location)
                    .setPositiveButton(R.string.confirm, this)
                    .setNegativeButton(R.string.cancel, this)
                    .show();
            return false;
        } else {
            return true;
        }
    }

    private void showNearbySites() {
        List<Attraction> sites = AttractionLogic.getInstance().getSites();
        for (Attraction site : sites) {
            addMarker(site);
        }
    }

    private void addMarker(Attraction site) {
        Marker marker = mGoogleMap.addMarker(new MarkerOptions()
                .position(new LatLng(site.getLatitude(), site.getLongitude()))
                .title(site.getName()));
        marker.setTag(site);
        mMarkers.add(marker);
    }

}
