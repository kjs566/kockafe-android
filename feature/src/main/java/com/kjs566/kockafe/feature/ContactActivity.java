package com.kjs566.kockafe.feature;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kjs566.kockafe.base.BaseActivity;

public class ContactActivity extends BaseActivity implements OnMapReadyCallback, View.OnClickListener {
    public static final int DIAL_PERMISION_REQUEST_CODE = 323;

    private GoogleMap mMap;
    private boolean callRequested = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.contact);
        setBackgroundImage(R.drawable.contact_background);
        inflateContent(R.layout.activity_contact_content);

        int[] buttonsIds = {R.id.btn_reservation, R.id.btn_address, R.id.btn_contact, R.id.btn_open_map};
        for (int id : buttonsIds) {
            findViewById(id).setOnClickListener(this);
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == DIAL_PERMISION_REQUEST_CODE && callRequested){
            tryToDial();
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_reservation) {
            tryToDial();
        }else if(id == R.id.btn_contact){
            sendEmail();
        }else if(id == R.id.btn_address || id == R.id.btn_open_map){
            openMap();
        }
    }

    private void tryToDial(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            callRequested = true;
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, DIAL_PERMISION_REQUEST_CODE);
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+420222722959"));
        startActivity(intent);
    }

    private void sendEmail(){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","kockafepraha@gmail.com", null));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, getString(R.string.send_email)));
        }
    }

    private void openMap(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.fromParts("geo", "0:0?q=50.082779,14.453231(" + getString(R.string.cat_cafe_map_marker) + ")", null));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            startActivity(Intent.createChooser(intent, getString(R.string.open_map)));
        }
    }


}

