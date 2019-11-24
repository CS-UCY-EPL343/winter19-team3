package com.example.trial2;

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
}