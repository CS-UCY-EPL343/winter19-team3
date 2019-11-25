package com.uridecy.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainState extends AppCompatActivity
        implements DriverFiltersDialogFragment.ItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_state);
    }

    public void showBottomSheet(View view) {
        DriverFiltersDialogFragment addPhotoBottomDialogFragment =
                DriverFiltersDialogFragment.newInstance();
        addPhotoBottomDialogFragment.show(getSupportFragmentManager(),
                DriverFiltersDialogFragment.TAG);
    }

    @Override
    public void onItemClick(String item) {

    }

    public void logout (View view){
        Intent intent = new Intent(this,LaunchScreen.class);
        startActivity(intent);
    }

    public void viewReceivedRideRequests (View view){
        Intent intent = new Intent(this,Request.class);
        startActivity(intent);
    }

    public void viewSettings(View view){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }

    public void viewMap(View view){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}