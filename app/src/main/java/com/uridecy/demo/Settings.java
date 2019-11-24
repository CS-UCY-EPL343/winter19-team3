package com.uridecy.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {
    private EditText model;
    private EditText brand;
    private EditText color;
    private EditText licenceplate;
    private CheckBox food;
    private CheckBox smoking;
    private CheckBox mobility;
    private Switch driver;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        model =findViewById(R.id.model);
        brand = findViewById(R.id.brand);
        color = findViewById(R.id.color);
        licenceplate = findViewById(R.id.licenceplate);
        food = findViewById(R.id.food);
        smoking = findViewById(R.id.smoking);
        mobility =findViewById(R.id.mobility);
        driver = findViewById(R.id.driver);
        ArrayList<View> view = new ArrayList<>();
        view.add(model);
        view.add(brand);
        view.add(color);
        view.add(licenceplate);
        view.add(food);
        view.add(smoking);
        view.add(mobility);
        driver.addChildrenForAccessibility(view);
        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driver.isChecked()) {
                    model.setVisibility(View.VISIBLE);
                    brand.setVisibility(View.VISIBLE);
                    color.setVisibility(View.VISIBLE);
                    licenceplate.setVisibility(View.VISIBLE);
                    food.setVisibility(View.VISIBLE);
                    smoking.setVisibility(View.VISIBLE);
                    mobility.setVisibility(View.VISIBLE);
                    model.setEnabled(true);
                    brand.setEnabled(true);
                    color.setEnabled(true );
                    licenceplate.setEnabled(true);
                    food.setEnabled(true);
                    smoking.setEnabled(true);
                    mobility.setEnabled(true);
                }
                if(!driver.isChecked()){
                   model.setEnabled(false);
                   brand.setEnabled(false);
                   color.setEnabled(false);
                   licenceplate.setEnabled(false);
                   food.setEnabled(false);
                   smoking.setEnabled(false);
                   mobility.setEnabled(false);
                }


            }
        });


    }


}
